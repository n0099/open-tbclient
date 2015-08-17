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
    private boolean bGQ = true;
    private ArrayList<String> bGR = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bGS = new HashMap<>();
    private HashMap<String, Integer> bGT = new HashMap<>();

    public void Xq() {
        this.bGQ = false;
    }

    public void Xr() {
        this.bGQ = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bGS.remove(gid);
                this.bGS.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bGR.add(gid);
                this.bGS.put(gid, imMessageCenterPojo);
                this.bGT.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bGQ && (size = this.bGR.size()) >= 4) {
                    for (String str : this.bGR.subList(0, size - 4)) {
                        this.bGR.remove(str);
                        this.bGS.remove(str);
                        this.bGT.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            ij(imMessageCenterPojo.getGid());
        }
    }

    public void ij(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGR.remove(str);
            this.bGR.add(str);
        }
    }

    public void ik(String str) {
        if (!StringUtils.isNull(str)) {
            this.bGR.remove(str);
            this.bGT.remove(str);
            this.bGS.remove(str);
        }
    }

    public void removeAll() {
        this.bGR.clear();
        this.bGT.clear();
        this.bGS.clear();
    }

    public int Xs() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bGS.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> Xt() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bGR.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bGS.get(this.bGR.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bGS.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bGT.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            ik(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bGR.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            il(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && Xv()) ? 6 : 0;
    }

    private void il(String str) {
        if (!StringUtils.isNull(str) && this.bGT.containsKey(str)) {
            this.bGT.put(str, 0);
        }
    }

    public ArrayList<UserData> Xu() {
        if (this.bGR == null || this.bGR.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bGR.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bGS.get(this.bGR.get(i));
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

    public boolean Xv() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bGS.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bGR.remove(value.getGid());
                this.bGT.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean Xw() {
        return (this.bGR == null || this.bGR.isEmpty()) ? false : true;
    }
}
