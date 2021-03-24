package com.baidu.wallet.lightapp.monitor;

import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class WhiteScreenConfig implements NoProguard {
    public boolean wsc_enable = false;
    public boolean wsc_view_enable = false;
    public int wsc_delay_time = 3000;
    public int wsc_wait_time = 500;
    public int wsc_core_cache = 2;
    public int wsc_core_task = 2;
    public int wsc_max_task = 5;
    public int wsc_alive_time = 10;
    public int wsc_area_detect = 9;
    public int wsc_general_detect = 1;
    public int wsc_simple_count = 3;

    public boolean isValid() {
        int i;
        int i2;
        int i3;
        return this.wsc_delay_time >= 0 && (i = this.wsc_core_cache) >= 0 && i <= 5 && this.wsc_core_task >= 1 && this.wsc_max_task >= 1 && this.wsc_alive_time > 0 && (i2 = this.wsc_area_detect) > 0 && i2 <= 9 && this.wsc_general_detect >= 0 && (i3 = this.wsc_simple_count) >= 1 && i3 <= 9;
    }
}
