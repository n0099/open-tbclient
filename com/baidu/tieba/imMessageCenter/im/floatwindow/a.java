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
    private boolean dpI = true;
    private ArrayList<String> dpJ = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> dpK = new HashMap<>();
    private HashMap<String, Integer> dpL = new HashMap<>();

    public void axE() {
        this.dpI = false;
    }

    public void axF() {
        this.dpI = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dpK.remove(gid);
                this.dpK.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.dpJ.add(gid);
                this.dpK.put(gid, imMessageCenterPojo);
                this.dpL.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.dpI && (size = this.dpJ.size()) >= 4) {
                    for (String str : this.dpJ.subList(0, size - 4)) {
                        this.dpJ.remove(str);
                        this.dpK.remove(str);
                        this.dpL.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            mq(imMessageCenterPojo.getGid());
        }
    }

    public void mq(String str) {
        if (!StringUtils.isNull(str)) {
            this.dpJ.remove(str);
            this.dpJ.add(str);
        }
    }

    public void mr(String str) {
        if (!StringUtils.isNull(str)) {
            this.dpJ.remove(str);
            this.dpL.remove(str);
            this.dpK.remove(str);
        }
    }

    public void removeAll() {
        this.dpJ.clear();
        this.dpL.clear();
        this.dpK.clear();
    }

    public int axG() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.dpK.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> axH() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.dpJ.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.dpK.get(this.dpJ.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.dpK.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.dpL.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            mr(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.dpJ.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            ms(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && axJ()) ? 6 : 0;
    }

    private void ms(String str) {
        if (!StringUtils.isNull(str) && this.dpL.containsKey(str)) {
            this.dpL.put(str, 0);
        }
    }

    public ArrayList<UserData> axI() {
        if (this.dpJ == null || this.dpJ.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.dpJ.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.dpK.get(this.dpJ.get(i));
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

    public void mt(String str) {
        if (!StringUtils.isNull(str) && this.dpK != null && this.dpK.get(str) != null) {
            this.dpK.get(str).setUnread_count(0);
        }
    }

    public boolean axJ() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.dpK.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.dpJ.remove(value.getGid());
                this.dpL.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean axK() {
        return (this.dpJ == null || this.dpJ.isEmpty()) ? false : true;
    }
}
