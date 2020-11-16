package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private Context eGZ;
    private LinearLayout eHb;
    private View eHd;
    private TextView eHe;
    private TextView etx;
    private List<C0873a> mItems;
    private d nzN;
    private b nzO;
    private boolean nzP;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void k(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.eGZ = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eHb = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.etx = (TextView) this.view.findViewById(R.id.title);
            this.eHd = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eHe = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eGZ;
    }

    public ViewGroup getView() {
        return this.eHb;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dSw() {
        return this.nzN;
    }

    public void br(List<C0873a> list) {
        if (list != null) {
            this.mItems = list;
            this.eHb.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0873a c0873a = list.get(i2);
                    if (c0873a != null) {
                        this.eHb.addView(c0873a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nzO = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.CAM_X0204);
        ap.setBackgroundResource(this.etx, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.etx, R.color.CAM_X0108);
        ap.setBackgroundColor(this.eHd, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eHe, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eHe, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0873a c0873a : this.mItems) {
                c0873a.onChangeSkinType();
            }
        }
        if (this.nzP) {
            if (!StringUtils.isNull(this.titleText) && this.etx != null && (this.etx.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.etx.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0873a c0873a2 = this.mItems.get(0);
                if (!c0873a2.nzT) {
                    c0873a2.nzT = true;
                    c0873a2.onChangeSkinType();
                }
            }
        }
    }

    public View bow() {
        if (!StringUtils.isNull(this.titleText)) {
            this.etx.setText(this.titleText);
            this.eHd.setVisibility(0);
        } else {
            this.etx.setVisibility(8);
            this.eHd.setVisibility(8);
        }
        if (this.nzO != null) {
            this.eHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nzO.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0873a {
        private View eGI;
        private int eGJ;
        private int eGK;
        private boolean eGM;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nzR;
        private c nzS;
        public boolean nzT;

        public C0873a(a aVar) {
            this(null, aVar);
        }

        public C0873a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eGJ = R.drawable.person_more_pop_item_bg_selector;
            this.eGK = 17;
            this.eGM = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0873a.this.nzS != null) {
                        C0873a.this.nzS.onClick();
                    }
                    if (C0873a.this.nzR != null && C0873a.this.nzR.dSw() != null) {
                        C0873a.this.nzR.dSw().k(C0873a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nzR = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.mText = str;
            this.mTextView.setText(this.mText);
        }

        public void a(c cVar) {
            this.nzS = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nzT) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.pt(R.color.CAM_X0211));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.eGI, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nzR != null && this.nzR.getContext() != null) {
                this.mView = LayoutInflater.from(this.nzR.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nzR.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eGK);
                this.eGI = this.mView.findViewById(R.id.divider_line);
                if (this.eGM) {
                    this.eGI.setVisibility(0);
                } else {
                    this.eGI.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.mTextView != null) {
                this.mTextView.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
