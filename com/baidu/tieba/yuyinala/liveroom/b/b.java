package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    private TextView hqd;
    private TbPageContext mContext;
    private View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_id_view_layout, (ViewGroup) null);
        this.hqd = (TextView) this.mView.findViewById(a.f.ala_id_txt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fw(long j) {
        if (this.hqd != null) {
            this.hqd.setText(String.format(this.mContext.getString(a.h.yuyin_sdk_live_id), String.valueOf(j)));
        }
    }

    public View getView() {
        return this.mView;
    }
}
