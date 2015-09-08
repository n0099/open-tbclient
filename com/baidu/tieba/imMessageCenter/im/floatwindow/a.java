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
    private boolean bHx = true;
    private ArrayList<String> bHy = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bHz = new HashMap<>();
    private HashMap<String, Integer> bHA = new HashMap<>();

    public void Xs() {
        this.bHx = false;
    }

    public void Xt() {
        this.bHx = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bHz.remove(gid);
                this.bHz.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bHy.add(gid);
                this.bHz.put(gid, imMessageCenterPojo);
                this.bHA.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bHx && (size = this.bHy.size()) >= 4) {
                    for (String str : this.bHy.subList(0, size - 4)) {
                        this.bHy.remove(str);
                        this.bHz.remove(str);
                        this.bHA.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            is(imMessageCenterPojo.getGid());
        }
    }

    public void is(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHy.remove(str);
            this.bHy.add(str);
        }
    }

    public void it(String str) {
        if (!StringUtils.isNull(str)) {
            this.bHy.remove(str);
            this.bHA.remove(str);
            this.bHz.remove(str);
        }
    }

    public void removeAll() {
        this.bHy.clear();
        this.bHA.clear();
        this.bHz.clear();
    }

    public int Xu() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bHz.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Xv() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bHy.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bHz.get(this.bHy.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bHz.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bHA.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            it(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bHy.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            iu(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Xx()) ? 6 : 0;
    }

    private void iu(String str) {
        if (!StringUtils.isNull(str) && this.bHA.containsKey(str)) {
            this.bHA.put(str, 0);
        }
    }

    public ArrayList<UserData> Xw() {
        if (this.bHy == null || this.bHy.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bHy.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bHz.get(this.bHy.get(i));
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

    public boolean Xx() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bHz.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bHy.remove(value.getGid());
                this.bHA.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Xy() {
        return (this.bHy == null || this.bHy.isEmpty()) ? false : true;
    }
}
