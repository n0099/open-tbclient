package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbLongPressTipView extends LinearLayout {
    private TextView aqv;
    private Context context;
    private TextView fab;
    private LinearLayout mRootView;
    private ImageView tipImage;

    public PbLongPressTipView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI(context);
    }

    public PbLongPressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pb_long_press_tip_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.pb_long_tip_content);
        this.tipImage = (ImageView) findViewById(R.id.pb_long_tip_image);
        this.aqv = (TextView) findViewById(R.id.long_hint_title);
        this.fab = (TextView) findViewById(R.id.long_hint_text);
        am.setViewTextColor(this.aqv, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fab, R.color.common_color_10037, 1);
        am.setImageResource(this.tipImage, R.drawable.pic_pb_popup_longpress);
    }
}
