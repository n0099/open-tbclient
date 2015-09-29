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
    private boolean bKC = true;
    private ArrayList<String> bKD = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bKE = new HashMap<>();
    private HashMap<String, Integer> bKF = new HashMap<>();

    public void Ya() {
        this.bKC = false;
    }

    public void Yb() {
        this.bKC = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bKE.remove(gid);
                this.bKE.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bKD.add(gid);
                this.bKE.put(gid, imMessageCenterPojo);
                this.bKF.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bKC && (size = this.bKD.size()) >= 4) {
                    for (String str : this.bKD.subList(0, size - 4)) {
                        this.bKD.remove(str);
                        this.bKE.remove(str);
                        this.bKF.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            iw(imMessageCenterPojo.getGid());
        }
    }

    public void iw(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKD.remove(str);
            this.bKD.add(str);
        }
    }

    public void ix(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKD.remove(str);
            this.bKF.remove(str);
            this.bKE.remove(str);
        }
    }

    public void removeAll() {
        this.bKD.clear();
        this.bKF.clear();
        this.bKE.clear();
    }

    public int Yc() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bKE.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Yd() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bKD.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bKE.get(this.bKD.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bKE.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bKF.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            ix(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bKD.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            iy(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Yf()) ? 6 : 0;
    }

    private void iy(String str) {
        if (!StringUtils.isNull(str) && this.bKF.containsKey(str)) {
            this.bKF.put(str, 0);
        }
    }

    public ArrayList<UserData> Ye() {
        if (this.bKD == null || this.bKD.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bKD.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bKE.get(this.bKD.get(i));
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

    public boolean Yf() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bKE.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bKD.remove(value.getGid());
                this.bKF.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Yg() {
        return (this.bKD == null || this.bKD.isEmpty()) ? false : true;
    }
}
