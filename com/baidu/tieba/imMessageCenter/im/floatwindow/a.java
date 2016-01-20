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
    private boolean cen = true;
    private ArrayList<String> ceo = new ArrayList<>();
    private HashMap<String, ImMessageCenterPojo> cep = new HashMap<>();
    private HashMap<String, Integer> ceq = new HashMap<>();

    public void acG() {
        this.cen = false;
    }

    public void acH() {
        this.cen = true;
    }

    private void p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.cep.remove(gid);
                this.cep.put(gid, imMessageCenterPojo);
            }
        }
    }

    private void q(ImMessageCenterPojo imMessageCenterPojo) {
        int size;
        if (imMessageCenterPojo != null) {
            String gid = imMessageCenterPojo.getGid();
            if (!StringUtils.isNull(gid)) {
                this.ceo.add(gid);
                this.cep.put(gid, imMessageCenterPojo);
                this.ceq.put(gid, Integer.valueOf(imMessageCenterPojo.getUnread_count()));
                if (this.cen && (size = this.ceo.size()) >= 4) {
                    for (String str : this.ceo.subList(0, size - 4)) {
                        this.ceo.remove(str);
                        this.cep.remove(str);
                        this.ceq.remove(str);
                    }
                }
            }
        }
    }

    private void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            jg(imMessageCenterPojo.getGid());
        }
    }

    public void jg(String str) {
        if (!StringUtils.isNull(str)) {
            this.ceo.remove(str);
            this.ceo.add(str);
        }
    }

    public void jh(String str) {
        if (!StringUtils.isNull(str)) {
            this.ceo.remove(str);
            this.ceq.remove(str);
            this.cep.remove(str);
        }
    }

    public void removeAll() {
        this.ceo.clear();
        this.ceq.clear();
        this.cep.clear();
    }

    public int acI() {
        int i = 0;
        Iterator<ImMessageCenterPojo> it = this.cep.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().getUnread_count() + i2;
            } else {
                return i2;
            }
        }
    }

    public ArrayList<String> acJ() {
        ArrayList<String> arrayList = new ArrayList<>();
        int size = this.ceo.size() - 1;
        if (size >= 0) {
            for (int i = size; i >= 0; i--) {
                ImMessageCenterPojo imMessageCenterPojo = this.cep.get(this.ceo.get(i));
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
        return (StringUtils.isNull(gid) || (imMessageCenterPojo2 = this.cep.get(gid)) == null || imMessageCenterPojo2 == imMessageCenterPojo) ? false : true;
    }

    private boolean t(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        String gid = imMessageCenterPojo.getGid();
        if (StringUtils.isNull(gid)) {
            return false;
        }
        Integer num = this.ceq.get(gid);
        return num == null || num.intValue() != imMessageCenterPojo.getUnread_count();
    }

    public int u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            jh(imMessageCenterPojo.getGid());
            return 5;
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (s(imMessageCenterPojo)) {
                p(imMessageCenterPojo);
                return 4;
            } else if (t(imMessageCenterPojo)) {
                if (this.ceo.contains(imMessageCenterPojo.getGid())) {
                    r(imMessageCenterPojo);
                    return 1;
                }
                q(imMessageCenterPojo);
                return 2;
            } else {
                return 0;
            }
        } else {
            ji(imMessageCenterPojo.getGid());
            return 3;
        }
    }

    public int v(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return 0;
        }
        return ((imMessageCenterPojo.getIs_hidden() == 1) && acL()) ? 6 : 0;
    }

    private void ji(String str) {
        if (!StringUtils.isNull(str) && this.ceq.containsKey(str)) {
            this.ceq.put(str, 0);
        }
    }

    public ArrayList<UserData> acK() {
        if (this.ceo == null || this.ceo.isEmpty()) {
            return null;
        }
        ArrayList<UserData> arrayList = new ArrayList<>();
        int size = this.ceo.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterPojo imMessageCenterPojo = this.cep.get(this.ceo.get(i));
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

    public boolean acL() {
        Iterator<Map.Entry<String, ImMessageCenterPojo>> it = this.cep.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ImMessageCenterPojo value = it.next().getValue();
            if (value.getIsFriend() != 1) {
                this.ceo.remove(value.getGid());
                this.ceq.remove(value.getGid());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public boolean acM() {
        return (this.ceo == null || this.ceo.isEmpty()) ? false : true;
    }
}
