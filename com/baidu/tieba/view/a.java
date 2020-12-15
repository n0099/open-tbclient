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
    private TextView eAz;
    private Context eOg;
    private LinearLayout eOi;
    private View eOl;
    private TextView eOm;
    private List<C0889a> mItems;
    private d nNR;
    private b nNS;
    private boolean nNT;
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
            this.eOg = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eOi = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eAz = (TextView) this.view.findViewById(R.id.title);
            this.eOl = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eOm = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eOg;
    }

    public ViewGroup getView() {
        return this.eOi;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dXR() {
        return this.nNR;
    }

    public void bu(List<C0889a> list) {
        if (list != null) {
            this.mItems = list;
            this.eOi.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0889a c0889a = list.get(i2);
                    if (c0889a != null) {
                        this.eOi.addView(c0889a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nNS = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eAz, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.eAz, R.color.CAM_X0108);
        ap.setBackgroundColor(this.eOl, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eOm, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eOm, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0889a c0889a : this.mItems) {
                c0889a.onChangeSkinType();
            }
        }
        if (this.nNT) {
            if (!StringUtils.isNull(this.titleText) && this.eAz != null && (this.eAz.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eAz.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0889a c0889a2 = this.mItems.get(0);
                if (!c0889a2.nNX) {
                    c0889a2.nNX = true;
                    c0889a2.onChangeSkinType();
                }
            }
        }
    }

    public View brP() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eAz.setText(this.titleText);
            this.eOl.setVisibility(0);
        } else {
            this.eAz.setVisibility(8);
            this.eOl.setVisibility(8);
        }
        if (this.nNS != null) {
            this.eOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nNS.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0889a {
        private View eNL;
        private int eNM;
        private int eNN;
        private boolean eNP;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nNV;
        private c nNW;
        public boolean nNX;

        public C0889a(a aVar) {
            this(null, aVar);
        }

        public C0889a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eNM = R.drawable.person_more_pop_item_bg_selector;
            this.eNN = 17;
            this.eNP = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0889a.this.nNW != null) {
                        C0889a.this.nNW.onClick();
                    }
                    if (C0889a.this.nNV != null && C0889a.this.nNV.dXR() != null) {
                        C0889a.this.nNV.dXR().k(C0889a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nNV = aVar;
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
            this.nNW = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nNX) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.pT(R.color.CAM_X0211));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.eNL, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nNV != null && this.nNV.getContext() != null) {
                this.mView = LayoutInflater.from(this.nNV.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nNV.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eNN);
                this.eNL = this.mView.findViewById(R.id.divider_line);
                if (this.eNP) {
                    this.eNL.setVisibility(0);
                } else {
                    this.eNL.setVisibility(8);
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
