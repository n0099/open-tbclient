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
    private boolean dcC = true;
    private ArrayList<String> dcD = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> dcE = new HashMap<>();
    private HashMap<String, Integer> dcF = new HashMap<>();

    public void asr() {
        this.dcC = false;
    }

    public void ass() {
        this.dcC = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dcE.remove(gid);
                this.dcE.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dcD.add(gid);
                this.dcE.put(gid, imMessageCenterPojo);
                this.dcF.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.dcC && (size = this.dcD.size()) >= 4) {
                    for (String str : this.dcD.subList(0, size - 4)) {
                        this.dcD.remove(str);
                        this.dcE.remove(str);
                        this.dcF.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            lu(imMessageCenterPojo.getGid());
        }
    }

    public void lu(String str) {
        if (!StringUtils.isNull(str)) {
            this.dcD.remove(str);
            this.dcD.add(str);
        }
    }

    public void lv(String str) {
        if (!StringUtils.isNull(str)) {
            this.dcD.remove(str);
            this.dcF.remove(str);
            this.dcE.remove(str);
        }
    }

    public void removeAll() {
        this.dcD.clear();
        this.dcF.clear();
        this.dcE.clear();
    }

    public int ast() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.dcE.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> asu() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.dcD.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.dcE.get(this.dcD.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.dcE.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.dcF.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            lv(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.dcD.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            lw(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && asw()) ? 6 : 0;
    }

    private void lw(String str) {
        if (!StringUtils.isNull(str) && this.dcF.containsKey(str)) {
            this.dcF.put(str, 0);
        }
    }

    public ArrayList<UserData> asv() {
        if (this.dcD == null || this.dcD.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.dcD.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.dcE.get(this.dcD.get(i));
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

    public void lx(String str) {
        if (!StringUtils.isNull(str) && this.dcE != null && this.dcE.get(str) != null) {
            this.dcE.get(str).setUnread_count(0);
        }
    }

    public boolean asw() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.dcE.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.dcD.remove(value.getGid());
                this.dcF.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean asx() {
        return (this.dcD == null || this.dcD.isEmpty()) ? false : true;
    }
}
