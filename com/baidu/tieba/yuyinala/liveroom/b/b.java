package com.baidu.tieba.yuyinala.liveroom.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b {
    private TextView gPr;
    private TbPageContext mContext;
    private View mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.yuyin_ala_id_view_layout, (ViewGroup) null);
        this.gPr = (TextView) this.mView.findViewById(a.g.ala_id_txt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ew(long j) {
        if (this.gPr != null) {
            this.gPr.setText(String.format(this.mContext.getString(a.i.yuyin_sdk_live_id), String.valueOf(j)));
        }
    }

    public View getView() {
        return this.mView;
    }
}
