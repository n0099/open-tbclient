package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HaloView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ChatterboxView extends FrameLayout {
    private boolean isManager;
    private LinearLayout mChatBox;
    public Context mContent;
    private HaloView mHaloView;
    public LinearLayout mParent;
    public Button mSelectBtn;
    private String mTitle;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;

    public ChatterboxView(Context context) {
        super(context);
        this.mParent = null;
        this.mSelectBtn = null;
        this.mContent = null;
        this.mHaloView = null;
        this.mChatBox = null;
        this.mTv1 = null;
        this.mTv2 = null;
        this.mTv3 = null;
        this.mTitle = null;
        this.isManager = false;
        init(context);
    }

    public ChatterboxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mParent = null;
        this.mSelectBtn = null;
        this.mContent = null;
        this.mHaloView = null;
        this.mChatBox = null;
        this.mTv1 = null;
        this.mTv2 = null;
        this.mTv3 = null;
        this.mTitle = null;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContent = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.chatterbox_view, this, true);
        this.mSelectBtn = (Button) findViewById(v.chat_select_btn);
        this.mHaloView = (HaloView) findViewById(v.haloView);
        this.mChatBox = (LinearLayout) findViewById(v.chat_view);
        this.mTv1 = (TextView) findViewById(v.chat_view_content_1);
        this.mTv2 = (TextView) findViewById(v.chat_view_content_2);
        this.mTv3 = (TextView) findViewById(v.chat_view_content_3);
    }

    public void setIsManager(boolean z, boolean z2) {
        boolean z3 = this.isManager;
        this.isManager = z;
        if (z2 || (!z3 && z3 != this.isManager)) {
            changedStyle();
        }
    }

    private void changedStyle() {
        this.mTitle = null;
        this.mTv1.setVisibility(8);
        this.mTv2.setVisibility(8);
        this.mTv3.setVisibility(8);
        this.mChatBox.setVisibility(8);
        if (this.isManager) {
            setVisibility(0);
            this.mHaloView.setIsBlack(false);
            this.mSelectBtn.setVisibility(0);
            return;
        }
        setVisibility(8);
        this.mHaloView.setIsBlack(true);
        this.mSelectBtn.setVisibility(8);
    }

    public void setTitle(String str) {
        if (str == null || !str.equals(this.mTitle)) {
            if (TextUtils.isEmpty(str)) {
                changedStyle();
                return;
            }
            setVisibility(0);
            this.mSelectBtn.setVisibility(8);
            this.mHaloView.setIsBlack(true);
            this.mChatBox.setVisibility(0);
            if (str.length() <= 7) {
                this.mTv1.setVisibility(0);
                this.mTv2.setVisibility(8);
                this.mTv3.setVisibility(8);
                this.mTv1.setText(str);
            } else if (str.length() <= 13) {
                this.mTv1.setVisibility(0);
                this.mTv2.setVisibility(0);
                this.mTv3.setVisibility(8);
                String substring = str.substring(0, 7);
                String substring2 = str.substring(7, str.length());
                this.mTv1.setText(substring);
                this.mTv2.setText(substring2);
            } else {
                this.mTv1.setVisibility(0);
                this.mTv2.setVisibility(0);
                this.mTv3.setVisibility(0);
                String substring3 = str.substring(0, 7);
                String substring4 = str.substring(7, 13);
                String substring5 = str.substring(13, str.length() <= 15 ? str.length() : 15);
                this.mTv1.setText(substring3);
                this.mTv2.setText(substring4);
                this.mTv3.setText(substring5);
            }
            this.mTitle = str;
        }
    }

    public boolean isEqualView(View view) {
        if (this.isManager) {
            return view == this.mSelectBtn || view == this.mChatBox;
        }
        return false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mSelectBtn.setOnClickListener(onClickListener);
        this.mChatBox.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.mHaloView.onDestroy();
    }
}
