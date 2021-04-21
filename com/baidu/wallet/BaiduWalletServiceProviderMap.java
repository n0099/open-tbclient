package com.baidu.wallet;

import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class BaiduWalletServiceProviderMap implements NoProguard {
    public static final String PLUGIN_FASTPAY = "fastpay";
    public static final String PLUGIN_LANGBRIGE = "langbrige";
    public static final String PLUGIN_NFC = "nfc";
    public static final String PLUGIN_PERSONAL = "personal";
    public static final String PLUGIN_QRCODESCANNER = "saoyisao";
    public static final String PLUGIN_TAB = "tab";
    public static final String PLUGIN_TRNASFER = "transfer";
    public static final String PLUGIN_WALLETHOME = "home";
    public Map<Long, String> maps;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduWalletServiceProviderMap f23048a = new BaiduWalletServiceProviderMap();
    }

    public static final BaiduWalletServiceProviderMap getInstance() {
        return a.f23048a;
    }

    private void initMaps() {
        this.maps.put(1L, PLUGIN_FASTPAY);
        this.maps.put(4096L, PLUGIN_FASTPAY);
        this.maps.put(2L, PLUGIN_TRNASFER);
        this.maps.put(64L, PLUGIN_PERSONAL);
        this.maps.put(1024L, PLUGIN_NFC);
        this.maps.put(32768L, PLUGIN_QRCODESCANNER);
        this.maps.put(16384L, PLUGIN_WALLETHOME);
        this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT), PLUGIN_WALLETHOME);
        this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING), PLUGIN_NFC);
        this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_LANGBRIGE), PLUGIN_LANGBRIGE);
        this.maps.put(Long.valueOf((long) WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE), "tab");
    }

    public void addDatas(Map<Long, String> map) {
        if (this.maps == null) {
            this.maps = new HashMap();
        }
        this.maps.putAll(map);
    }

    public String getProviderNameBySerID(long j) {
        Map<Long, String> map = this.maps;
        return (map == null || map.size() <= 0) ? "" : this.maps.get(Long.valueOf(j));
    }

    public BaiduWalletServiceProviderMap() {
        this.maps = new HashMap();
        initMaps();
    }
}
