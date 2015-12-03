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
    private boolean cam = true;
    private ArrayList<String> can = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> cao = new HashMap<>();
    private HashMap<String, Integer> cap = new HashMap<>();

    public void abx() {
        this.cam = false;
    }

    public void aby() {
        this.cam = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cao.remove(gid);
                this.cao.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.can.add(gid);
                this.cao.put(gid, imMessageCenterPojo);
                this.cap.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.cam && (size = this.can.size()) >= 4) {
                    for (String str : this.can.subList(0, size - 4)) {
                        this.can.remove(str);
                        this.cao.remove(str);
                        this.cap.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            iS(imMessageCenterPojo.getGid());
        }
    }

    public void iS(String str) {
        if (!StringUtils.isNull(str)) {
            this.can.remove(str);
            this.can.add(str);
        }
    }

    public void iT(String str) {
        if (!StringUtils.isNull(str)) {
            this.can.remove(str);
            this.cap.remove(str);
            this.cao.remove(str);
        }
    }

    public void removeAll() {
        this.can.clear();
        this.cap.clear();
        this.cao.clear();
    }

    public int abz() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.cao.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> abA() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.can.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.cao.get(this.can.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.cao.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.cap.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            iT(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.can.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            iU(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && abC()) ? 6 : 0;
    }

    private void iU(String str) {
        if (!StringUtils.isNull(str) && this.cap.containsKey(str)) {
            this.cap.put(str, 0);
        }
    }

    public ArrayList<UserData> abB() {
        if (this.can == null || this.can.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.can.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.cao.get(this.can.get(i));
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

    public boolean abC() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.cao.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.can.remove(value.getGid());
                this.cap.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean abD() {
        return (this.can == null || this.can.isEmpty()) ? false : true;
    }
}
