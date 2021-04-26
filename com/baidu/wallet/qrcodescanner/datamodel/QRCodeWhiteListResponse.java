package com.baidu.wallet.qrcodescanner.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.wallet.core.NoProguard;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class QRCodeWhiteListResponse implements IBeanResponse {
    public Category whitelist;

    /* loaded from: classes5.dex */
    public static class Category implements NoProguard {
        public Group[] data;
        public String fingerprint;
    }

    /* loaded from: classes5.dex */
    public static class Group implements NoProguard {
        public String blacklist_preg;
        public String end_time;
        public String lightapp_outer_open_preg;
        public Item[] list;
        public String shorturl_preg;
        public String shorturl_preg_new;
        public String start_time;
        public String title_advert_logo;
        public String title_link_addr;
        public String title_type;
        public String title_value;
        public String url_preg;
    }

    /* loaded from: classes5.dex */
    public static class Item implements NoProguard {
        public String whitelist_preg;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return this.whitelist != null;
    }

    public void doStoreResponse(Context context) {
        String json = JsonUtils.toJson(this);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        String encodeBytes = Base64.encodeBytes(json.getBytes());
        FileCopyUtils.copyToFile(encodeBytes, new File(context.getCacheDir() + "/qrcode_scanner_1.cfg"));
    }

    public Group getBanner() {
        if (hasData()) {
            return this.whitelist.data[0];
        }
        return null;
    }

    public List<Group> getDataGroup() {
        ArrayList arrayList = new ArrayList();
        if (hasData()) {
            Group[] groupArr = this.whitelist.data;
            arrayList.addAll(Arrays.asList(groupArr).subList(0, groupArr.length));
        }
        return arrayList;
    }

    public List<Item> getWhiteLists() {
        Item[] itemArr;
        ArrayList arrayList = new ArrayList();
        if (hasData()) {
            Group[] groupArr = this.whitelist.data;
            int length = groupArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (groupArr[i2].list != null) {
                    for (Item item : groupArr[i2].list) {
                        if (item != null) {
                            arrayList.add(item);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean hasData() {
        Group[] groupArr;
        Category category = this.whitelist;
        return (category == null || (groupArr = category.data) == null || groupArr.length <= 0) ? false : true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
