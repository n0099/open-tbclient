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
    private boolean ciM = true;
    private ArrayList<String> ciN = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> ciO = new HashMap<>();
    private HashMap<String, Integer> ciP = new HashMap<>();

    public void afP() {
        this.ciM = false;
    }

    public void afQ() {
        this.ciM = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.ciO.remove(gid);
                this.ciO.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.ciN.add(gid);
                this.ciO.put(gid, imMessageCenterPojo);
                this.ciP.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.ciM && (size = this.ciN.size()) >= 4) {
                    for (String str : this.ciN.subList(0, size - 4)) {
                        this.ciN.remove(str);
                        this.ciO.remove(str);
                        this.ciP.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ji(imMessageCenterPojo.getGid());
        }
    }

    public void ji(String str) {
        if (!StringUtils.isNull(str)) {
            this.ciN.remove(str);
            this.ciN.add(str);
        }
    }

    public void jj(String str) {
        if (!StringUtils.isNull(str)) {
            this.ciN.remove(str);
            this.ciP.remove(str);
            this.ciO.remove(str);
        }
    }

    public void removeAll() {
        this.ciN.clear();
        this.ciP.clear();
        this.ciO.clear();
    }

    public int afR() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.ciO.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> afS() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.ciN.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.ciO.get(this.ciN.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.ciO.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.ciP.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            jj(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.ciN.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            jk(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && afU()) ? 6 : 0;
    }

    private void jk(String str) {
        if (!StringUtils.isNull(str) && this.ciP.containsKey(str)) {
            this.ciP.put(str, 0);
        }
    }

    public ArrayList<UserData> afT() {
        if (this.ciN == null || this.ciN.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.ciN.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.ciO.get(this.ciN.get(i));
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

    public void jl(String str) {
        if (!StringUtils.isNull(str) && this.ciO != null && this.ciO.get(str) != null) {
            this.ciO.get(str).setUnread_count(0);
        }
    }

    public boolean afU() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.ciO.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.ciN.remove(value.getGid());
                this.ciP.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean afV() {
        return (this.ciN == null || this.ciN.isEmpty()) ? false : true;
    }
}
