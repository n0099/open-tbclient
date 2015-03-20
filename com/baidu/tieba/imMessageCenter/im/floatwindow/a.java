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
    private boolean bpY = true;
    private ArrayList<String> bpZ = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bqa = new HashMap<>();
    private HashMap<String, Integer> bqb = new HashMap<>();

    public void Ue() {
        this.bpY = false;
    }

    public void Uf() {
        this.bpY = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bqa.remove(gid);
                this.bqa.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bpZ.add(gid);
                this.bqa.put(gid, imMessageCenterPojo);
                this.bqb.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bpY && (size = this.bpZ.size()) >= 4) {
                    for (String str : this.bpZ.subList(0, size - 4)) {
                        this.bpZ.remove(str);
                        this.bqa.remove(str);
                        this.bqb.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ha(imMessageCenterPojo.getGid());
        }
    }

    public void ha(String str) {
        if (!StringUtils.isNull(str)) {
            this.bpZ.remove(str);
            this.bpZ.add(str);
        }
    }

    public void hb(String str) {
        if (!StringUtils.isNull(str)) {
            this.bpZ.remove(str);
            this.bqb.remove(str);
            this.bqa.remove(str);
        }
    }

    public void removeAll() {
        this.bpZ.clear();
        this.bqb.clear();
        this.bqa.clear();
    }

    public int Ug() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bqa.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Uh() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bpZ.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bqa.get(this.bpZ.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bqa.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bqb.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            hb(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bpZ.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            hc(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Uj()) ? 6 : 0;
    }

    private void hc(String str) {
        if (!StringUtils.isNull(str) && this.bqb.containsKey(str)) {
            this.bqb.put(str, 0);
        }
    }

    public ArrayList<UserData> Ui() {
        if (this.bpZ == null || this.bpZ.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bpZ.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bqa.get(this.bpZ.get(i));
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

    public boolean Uj() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bqa.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bpZ.remove(value.getGid());
                this.bqb.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Uk() {
        return (this.bpZ == null || this.bpZ.isEmpty()) ? false : true;
    }
}
