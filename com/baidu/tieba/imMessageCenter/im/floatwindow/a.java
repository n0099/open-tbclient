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
    private boolean bsX = true;
    private ArrayList<String> bsY = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bsZ = new HashMap<>();
    private HashMap<String, Integer> bta = new HashMap<>();

    public void VI() {
        this.bsX = false;
    }

    public void VJ() {
        this.bsX = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bsZ.remove(gid);
                this.bsZ.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bsY.add(gid);
                this.bsZ.put(gid, imMessageCenterPojo);
                this.bta.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bsX && (size = this.bsY.size()) >= 4) {
                    for (String str : this.bsY.subList(0, size - 4)) {
                        this.bsY.remove(str);
                        this.bsZ.remove(str);
                        this.bta.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            hG(imMessageCenterPojo.getGid());
        }
    }

    public void hG(String str) {
        if (!StringUtils.isNull(str)) {
            this.bsY.remove(str);
            this.bsY.add(str);
        }
    }

    public void hH(String str) {
        if (!StringUtils.isNull(str)) {
            this.bsY.remove(str);
            this.bta.remove(str);
            this.bsZ.remove(str);
        }
    }

    public void removeAll() {
        this.bsY.clear();
        this.bta.clear();
        this.bsZ.clear();
    }

    public int VK() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bsZ.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> VL() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bsY.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bsZ.get(this.bsY.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bsZ.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.bta.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            hH(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.bsY.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            hI(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && VN()) ? 6 : 0;
    }

    private void hI(String str) {
        if (!StringUtils.isNull(str) && this.bta.containsKey(str)) {
            this.bta.put(str, 0);
        }
    }

    public ArrayList<UserData> VM() {
        if (this.bsY == null || this.bsY.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bsY.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bsZ.get(this.bsY.get(i));
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

    public boolean VN() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bsZ.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bsY.remove(value.getGid());
                this.bta.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean VO() {
        return (this.bsY == null || this.bsY.isEmpty()) ? false : true;
    }
}
