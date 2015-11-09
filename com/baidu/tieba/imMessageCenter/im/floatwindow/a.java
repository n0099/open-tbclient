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
    private boolean bLi = true;
    private ArrayList<String> bLj = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bLk = new HashMap<>();
    private HashMap<String, Integer> bLl = new HashMap<>();

    public void Yr() {
        this.bLi = false;
    }

    public void Ys() {
        this.bLi = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bLk.remove(gid);
                this.bLk.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bLj.add(gid);
                this.bLk.put(gid, imMessageCenterPojo);
                this.bLl.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bLi && (size = this.bLj.size()) >= 4) {
                    for (String str : this.bLj.subList(0, size - 4)) {
                        this.bLj.remove(str);
                        this.bLk.remove(str);
                        this.bLl.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            iy(imMessageCenterPojo.getGid());
        }
    }

    public void iy(String str) {
        if (!StringUtils.isNull(str)) {
            this.bLj.remove(str);
            this.bLj.add(str);
        }
    }

    public void iz(String str) {
        if (!StringUtils.isNull(str)) {
            this.bLj.remove(str);
            this.bLl.remove(str);
            this.bLk.remove(str);
        }
    }

    public void removeAll() {
        this.bLj.clear();
        this.bLl.clear();
        this.bLk.clear();
    }

    public int Yt() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bLk.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Yu() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bLj.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bLk.get(this.bLj.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bLk.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bLl.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            iz(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bLj.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            iA(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Yw()) ? 6 : 0;
    }

    private void iA(String str) {
        if (!StringUtils.isNull(str) && this.bLl.containsKey(str)) {
            this.bLl.put(str, 0);
        }
    }

    public ArrayList<UserData> Yv() {
        if (this.bLj == null || this.bLj.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bLj.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bLk.get(this.bLj.get(i));
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

    public boolean Yw() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bLk.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bLj.remove(value.getGid());
                this.bLl.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Yx() {
        return (this.bLj == null || this.bLj.isEmpty()) ? false : true;
    }
}
