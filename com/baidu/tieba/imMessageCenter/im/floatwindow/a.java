package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private boolean cZE = true;
    private ArrayList<String> cZF = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> cZG = new HashMap<>();
    private HashMap<String, Integer> cZH = new HashMap<>();

    public void arF() {
        this.cZE = false;
    }

    public void arG() {
        this.cZE = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cZG.remove(gid);
                this.cZG.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cZF.add(gid);
                this.cZG.put(gid, imMessageCenterPojo);
                this.cZH.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.cZE && (size = this.cZF.size()) >= 4) {
                    for (String str : this.cZF.subList(0, size - 4)) {
                        this.cZF.remove(str);
                        this.cZG.remove(str);
                        this.cZH.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ln(imMessageCenterPojo.getGid());
        }
    }

    public void ln(String str) {
        if (!StringUtils.isNull(str)) {
            this.cZF.remove(str);
            this.cZF.add(str);
        }
    }

    public void lo(String str) {
        if (!StringUtils.isNull(str)) {
            this.cZF.remove(str);
            this.cZH.remove(str);
            this.cZG.remove(str);
        }
    }

    public void removeAll() {
        this.cZF.clear();
        this.cZH.clear();
        this.cZG.clear();
    }

    public int arH() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.cZG.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> arI() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.cZF.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.cZG.get(this.cZF.get(i));
                if (imMessageCenterPojo != null) {
                    arrayList.add(imMessageCenterPojo.getGroup_head());
                }
            }
        }
        return arrayList;
    }

    private boolean s(ImMessageCenterPojo imMessageCenterPojo) {
        ImMessageCenterPojo imMessageCenterPojo2;
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.cZG.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.cZH.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            lo(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.cZF.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            lp(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && arK()) ? 6 : 0;
    }

    private void lp(String str) {
        if (!StringUtils.isNull(str) && this.cZH.containsKey(str)) {
            this.cZH.put(str, 0);
        }
    }

    public ArrayList<UserData> arJ() {
        if (this.cZF == null || this.cZF.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.cZF.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.cZG.get(this.cZF.get(i));
            if (imMessageCenterPojo != null) {
                UserData userData = new UserData();
                userData.setUserId(imMessageCenterPojo.getGid());
                userData.setUserName(imMessageCenterPojo.getGroup_name());
                userData.setPortrait(imMessageCenterPojo.getGroup_head());
                if (i == size - 1) {
                    userData.setConcern_num(0);
                } else {
                    userData.setConcern_num(imMessageCenterPojo.getUnread_count());
                }
                userData.setIsFriend(imMessageCenterPojo.getIsFriend());
                arrayList.add(userData);
            }
        }
        return arrayList;
    }

    public void lq(String str) {
        if (!StringUtils.isNull(str) && this.cZG != null && this.cZG.get(str) != null) {
            this.cZG.get(str).setUnread_count(0);
        }
    }

    public boolean arK() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.cZG.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.cZF.remove(value.getGid());
                this.cZH.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean arL() {
        return (this.cZF == null || this.cZF.isEmpty()) ? false : true;
    }
}
