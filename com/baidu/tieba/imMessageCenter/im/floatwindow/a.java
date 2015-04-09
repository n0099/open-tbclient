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
    private boolean bqo = true;
    private ArrayList<String> bqp = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bqq = new HashMap<>();
    private HashMap<String, Integer> bqr = new HashMap<>();

    public void Ur() {
        this.bqo = false;
    }

    public void Us() {
        this.bqo = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bqq.remove(gid);
                this.bqq.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bqp.add(gid);
                this.bqq.put(gid, imMessageCenterPojo);
                this.bqr.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bqo && (size = this.bqp.size()) >= 4) {
                    for (String str : this.bqp.subList(0, size - 4)) {
                        this.bqp.remove(str);
                        this.bqq.remove(str);
                        this.bqr.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            hd(imMessageCenterPojo.getGid());
        }
    }

    public void hd(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqp.remove(str);
            this.bqp.add(str);
        }
    }

    public void he(String str) {
        if (!StringUtils.isNull(str)) {
            this.bqp.remove(str);
            this.bqr.remove(str);
            this.bqq.remove(str);
        }
    }

    public void removeAll() {
        this.bqp.clear();
        this.bqr.clear();
        this.bqq.clear();
    }

    public int Ut() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bqq.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Uu() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bqp.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bqq.get(this.bqp.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bqq.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bqr.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            he(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bqp.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            hf(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Uw()) ? 6 : 0;
    }

    private void hf(String str) {
        if (!StringUtils.isNull(str) && this.bqr.containsKey(str)) {
            this.bqr.put(str, 0);
        }
    }

    public ArrayList<UserData> Uv() {
        if (this.bqp == null || this.bqp.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bqp.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bqq.get(this.bqp.get(i));
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

    public boolean Uw() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bqq.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bqp.remove(value.getGid());
                this.bqr.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Ux() {
        return (this.bqp == null || this.bqp.isEmpty()) ? false : true;
    }
}
