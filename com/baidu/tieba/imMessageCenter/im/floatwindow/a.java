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
    private boolean bsY = true;
    private ArrayList<String> bsZ = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> bta = new HashMap<>();
    private HashMap<String, Integer> btb = new HashMap<>();

    public void VJ() {
        this.bsY = false;
    }

    public void VK() {
        this.bsY = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bta.remove(gid);
                this.bta.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.bsZ.add(gid);
                this.bta.put(gid, imMessageCenterPojo);
                this.btb.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.bsY && (size = this.bsZ.size()) >= 4) {
                    for (String str : this.bsZ.subList(0, size - 4)) {
                        this.bsZ.remove(str);
                        this.bta.remove(str);
                        this.btb.remove(str);
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
            this.bsZ.remove(str);
            this.bsZ.add(str);
        }
    }

    public void hH(String str) {
        if (!StringUtils.isNull(str)) {
            this.bsZ.remove(str);
            this.btb.remove(str);
            this.bta.remove(str);
        }
    }

    public void removeAll() {
        this.bsZ.clear();
        this.btb.clear();
        this.bta.clear();
    }

    public int VL() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.bta.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> VM() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.bsZ.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.bta.get(this.bsZ.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.bta.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.btb.get(gid);
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
                if (this.bsZ.contains(imMessageCenterPojo.getGid())) {
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
        return ((imMessageCenterPojo.getIs_hidden() == 1) && VO()) ? 6 : 0;
    }

    private void hI(String str) {
        if (!StringUtils.isNull(str) && this.btb.containsKey(str)) {
            this.btb.put(str, 0);
        }
    }

    public ArrayList<UserData> VN() {
        if (this.bsZ == null || this.bsZ.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.bsZ.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.bta.get(this.bsZ.get(i));
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

    public boolean VO() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.bta.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.bsZ.remove(value.getGid());
                this.btb.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean VP() {
        return (this.bsZ == null || this.bsZ.isEmpty()) ? false : true;
    }
}
