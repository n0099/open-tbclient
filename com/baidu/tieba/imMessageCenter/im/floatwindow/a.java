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
    private boolean cup = true;
    private ArrayList<String> cuq = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> cur = new HashMap<>();
    private HashMap<String, Integer> cus = new HashMap<>();

    public void ajr() {
        this.cup = false;
    }

    public void ajs() {
        this.cup = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cur.remove(gid);
                this.cur.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cuq.add(gid);
                this.cur.put(gid, imMessageCenterPojo);
                this.cus.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.cup && (size = this.cuq.size()) >= 4) {
                    for (String str : this.cuq.subList(0, size - 4)) {
                        this.cuq.remove(str);
                        this.cur.remove(str);
                        this.cus.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jU(imMessageCenterPojo.getGid());
        }
    }

    public void jU(String str) {
        if (!StringUtils.isNull(str)) {
            this.cuq.remove(str);
            this.cuq.add(str);
        }
    }

    public void jV(String str) {
        if (!StringUtils.isNull(str)) {
            this.cuq.remove(str);
            this.cus.remove(str);
            this.cur.remove(str);
        }
    }

    public void removeAll() {
        this.cuq.clear();
        this.cus.clear();
        this.cur.clear();
    }

    public int ajt() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.cur.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> aju() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.cuq.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.cur.get(this.cuq.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.cur.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.cus.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            jV(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.cuq.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            jW(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && ajw()) ? 6 : 0;
    }

    private void jW(String str) {
        if (!StringUtils.isNull(str) && this.cus.containsKey(str)) {
            this.cus.put(str, 0);
        }
    }

    public ArrayList<UserData> ajv() {
        if (this.cuq == null || this.cuq.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.cuq.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.cur.get(this.cuq.get(i));
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

    public void jX(String str) {
        if (!StringUtils.isNull(str) && this.cur != null && this.cur.get(str) != null) {
            this.cur.get(str).setUnread_count(0);
        }
    }

    public boolean ajw() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.cur.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.cuq.remove(value.getGid());
                this.cus.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean ajx() {
        return (this.cuq == null || this.cuq.isEmpty()) ? false : true;
    }
}
