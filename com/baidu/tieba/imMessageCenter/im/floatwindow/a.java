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
    private boolean ctr = true;
    private ArrayList<String> cts = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> ctt = new HashMap<>();
    private HashMap<String, Integer> ctu = new HashMap<>();

    public void ajj() {
        this.ctr = false;
    }

    public void ajk() {
        this.ctr = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.ctt.remove(gid);
                this.ctt.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cts.add(gid);
                this.ctt.put(gid, imMessageCenterPojo);
                this.ctu.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.ctr && (size = this.cts.size()) >= 4) {
                    for (String str : this.cts.subList(0, size - 4)) {
                        this.cts.remove(str);
                        this.ctt.remove(str);
                        this.ctu.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jR(imMessageCenterPojo.getGid());
        }
    }

    public void jR(String str) {
        if (!StringUtils.isNull(str)) {
            this.cts.remove(str);
            this.cts.add(str);
        }
    }

    public void jS(String str) {
        if (!StringUtils.isNull(str)) {
            this.cts.remove(str);
            this.ctu.remove(str);
            this.ctt.remove(str);
        }
    }

    public void removeAll() {
        this.cts.clear();
        this.ctu.clear();
        this.ctt.clear();
    }

    public int ajl() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.ctt.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> ajm() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.cts.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.ctt.get(this.cts.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.ctt.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.ctu.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            jS(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.cts.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            jT(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && ajo()) ? 6 : 0;
    }

    private void jT(String str) {
        if (!StringUtils.isNull(str) && this.ctu.containsKey(str)) {
            this.ctu.put(str, 0);
        }
    }

    public ArrayList<UserData> ajn() {
        if (this.cts == null || this.cts.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.cts.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.ctt.get(this.cts.get(i));
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

    public void jU(String str) {
        if (!StringUtils.isNull(str) && this.ctt != null && this.ctt.get(str) != null) {
            this.ctt.get(str).setUnread_count(0);
        }
    }

    public boolean ajo() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.ctt.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.cts.remove(value.getGid());
                this.ctu.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean ajp() {
        return (this.cts == null || this.cts.isEmpty()) ? false : true;
    }
}
