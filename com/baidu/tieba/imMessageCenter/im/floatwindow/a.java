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
    private boolean dok = true;
    private ArrayList<String> dol = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> dom = new HashMap<>();
    private HashMap<String, Integer> don = new HashMap<>();

    public void axf() {
        this.dok = false;
    }

    public void axg() {
        this.dok = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dom.remove(gid);
                this.dom.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dol.add(gid);
                this.dom.put(gid, imMessageCenterPojo);
                this.don.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.dok && (size = this.dol.size()) >= 4) {
                    for (String str : this.dol.subList(0, size - 4)) {
                        this.dol.remove(str);
                        this.dom.remove(str);
                        this.don.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            md(imMessageCenterPojo.getGid());
        }
    }

    public void md(String str) {
        if (!StringUtils.isNull(str)) {
            this.dol.remove(str);
            this.dol.add(str);
        }
    }

    public void me(String str) {
        if (!StringUtils.isNull(str)) {
            this.dol.remove(str);
            this.don.remove(str);
            this.dom.remove(str);
        }
    }

    public void removeAll() {
        this.dol.clear();
        this.don.clear();
        this.dom.clear();
    }

    public int axh() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.dom.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> axi() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.dol.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.dom.get(this.dol.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.dom.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.don.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            me(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.dol.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            mf(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && axk()) ? 6 : 0;
    }

    private void mf(String str) {
        if (!StringUtils.isNull(str) && this.don.containsKey(str)) {
            this.don.put(str, 0);
        }
    }

    public ArrayList<UserData> axj() {
        if (this.dol == null || this.dol.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.dol.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.dom.get(this.dol.get(i));
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

    public void mg(String str) {
        if (!StringUtils.isNull(str) && this.dom != null && this.dom.get(str) != null) {
            this.dom.get(str).setUnread_count(0);
        }
    }

    public boolean axk() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.dom.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.dol.remove(value.getGid());
                this.don.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean axl() {
        return (this.dol == null || this.dol.isEmpty()) ? false : true;
    }
}
