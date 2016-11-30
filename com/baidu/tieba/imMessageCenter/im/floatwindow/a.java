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
    private boolean dvp = true;
    private ArrayList<String> dvq = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> dvr = new HashMap<>();
    private HashMap<String, Integer> dvs = new HashMap<>();

    public void azB() {
        this.dvp = false;
    }

    public void azC() {
        this.dvp = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dvr.remove(gid);
                this.dvr.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dvq.add(gid);
                this.dvr.put(gid, imMessageCenterPojo);
                this.dvs.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.dvp && (size = this.dvq.size()) >= 4) {
                    for (String str : this.dvq.subList(0, size - 4)) {
                        this.dvq.remove(str);
                        this.dvr.remove(str);
                        this.dvs.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            mD(imMessageCenterPojo.getGid());
        }
    }

    public void mD(String str) {
        if (!StringUtils.isNull(str)) {
            this.dvq.remove(str);
            this.dvq.add(str);
        }
    }

    public void mE(String str) {
        if (!StringUtils.isNull(str)) {
            this.dvq.remove(str);
            this.dvs.remove(str);
            this.dvr.remove(str);
        }
    }

    public void removeAll() {
        this.dvq.clear();
        this.dvs.clear();
        this.dvr.clear();
    }

    public int azD() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.dvr.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> azE() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.dvq.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.dvr.get(this.dvq.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.dvr.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.dvs.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            mE(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.dvq.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            mF(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && azG()) ? 6 : 0;
    }

    private void mF(String str) {
        if (!StringUtils.isNull(str) && this.dvs.containsKey(str)) {
            this.dvs.put(str, 0);
        }
    }

    public ArrayList<UserData> azF() {
        if (this.dvq == null || this.dvq.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.dvq.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.dvr.get(this.dvq.get(i));
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

    public void mG(String str) {
        if (!StringUtils.isNull(str) && this.dvr != null && this.dvr.get(str) != null) {
            this.dvr.get(str).setUnread_count(0);
        }
    }

    public boolean azG() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.dvr.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.dvq.remove(value.getGid());
                this.dvs.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean azH() {
        return (this.dvq == null || this.dvq.isEmpty()) ? false : true;
    }
}
