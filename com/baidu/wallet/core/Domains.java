package com.baidu.wallet.core;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class Domains implements NoProguard {
    public static final EnumSet<Permission> ALL_PERMISSION;
    public static final String BAIDU = ".baidu.com";
    public static final String BAIFUBAO = ".baifubao.com";
    public static final String BAI_YING_FUND = ".baiyingfund.com";
    public static final Map<String, EnumSet<Permission>> DEFAULT_PERMISSION_CONFIG = new HashMap();
    public static final String DU_XIAO_MAN = ".duxiaoman.com";
    public static final String DU_XIAO_MAN_FUND = ".duxiaomanfund.com";
    public static final String DU_XIAO_MAN_INT = ".duxiaoman-int.com";
    public static final String DU_XIAO_MAN_PAY = ".dxmpay.com";
    public static final String NUOMI = ".nuomi.com";
    public Map<String, EnumSet<Permission>> mDomainsPermissionConfig;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Domains f23826a = new Domains();
    }

    static {
        EnumSet<Permission> of = EnumSet.of(Permission.NONE, Permission.READ_NORMAL, Permission.READ_PRIVATE, Permission.WRITE, Permission.READ_DEVICE);
        ALL_PERMISSION = of;
        DEFAULT_PERMISSION_CONFIG.put(BAIDU, of);
        DEFAULT_PERMISSION_CONFIG.put(NUOMI, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(BAIFUBAO, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(BAI_YING_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_PAY, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_INT, ALL_PERMISSION);
    }

    public static final Domains getInstance() {
        return a.f23826a;
    }

    public Map<String, EnumSet<Permission>> getDomainsPermissionConfig() {
        Map<String, EnumSet<Permission>> map = this.mDomainsPermissionConfig;
        if (map != null && !map.isEmpty()) {
            return this.mDomainsPermissionConfig;
        }
        return DEFAULT_PERMISSION_CONFIG;
    }

    public void setDomainsPermissionConfig(Map<String, EnumSet<Permission>> map) {
        this.mDomainsPermissionConfig = map;
    }

    public Domains() {
    }
}
