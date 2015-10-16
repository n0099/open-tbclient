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
    private boolean bKN = true;
    private ArrayList<String> bKO = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bKP = new HashMap<>();
    private HashMap<String, Integer> bKQ = new HashMap<>();

    public void Ya() {
        this.bKN = false;
    }

    public void Yb() {
        this.bKN = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bKP.remove(gid);
                this.bKP.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bKO.add(gid);
                this.bKP.put(gid, imMessageCenterPojo);
                this.bKQ.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bKN && (size = this.bKO.size()) >= 4) {
                    for (String str : this.bKO.subList(0, size - 4)) {
                        this.bKO.remove(str);
                        this.bKP.remove(str);
                        this.bKQ.remove(str);
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
            this.bKO.remove(str);
            this.bKO.add(str);
        }
    }

    public void ix(String str) {
        if (!StringUtils.isNull(str)) {
            this.bKO.remove(str);
            this.bKQ.remove(str);
            this.bKP.remove(str);
        }
    }

    public void removeAll() {
        this.bKO.clear();
        this.bKQ.clear();
        this.bKP.clear();
    }

    public int Yc() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bKP.values().iterator();
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
        int size = this.bKO.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bKP.get(this.bKO.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bKP.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bKQ.get(gid);
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
                if (this.bKO.contains(imMessageCenterPojo.getGid())) {
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
        if (!StringUtils.isNull(str) && this.bKQ.containsKey(str)) {
            this.bKQ.put(str, 0);
        }
    }

    public ArrayList<UserData> Ye() {
        if (this.bKO == null || this.bKO.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bKO.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bKP.get(this.bKO.get(i));
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
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bKP.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bKO.remove(value.getGid());
                this.bKQ.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Yg() {
        return (this.bKO == null || this.bKO.isEmpty()) ? false : true;
    }
}
