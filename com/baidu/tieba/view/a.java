package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView eFr;
    private Context eTs;
    private LinearLayout eTu;
    private View eTx;
    private TextView eTy;
    private List<C0892a> mItems;
    private d nMH;
    private b nMI;
    private boolean nMJ;
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
            this.eTs = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eTu = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eFr = (TextView) this.view.findViewById(R.id.title);
            this.eTx = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eTy = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eTs;
    }

    public ViewGroup getView() {
        return this.eTu;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dTD() {
        return this.nMH;
    }

    public void bB(List<C0892a> list) {
        if (list != null) {
            this.mItems = list;
            this.eTu.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0892a c0892a = list.get(i2);
                    if (c0892a != null) {
                        this.eTu.addView(c0892a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nMI = bVar;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.view, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eFr, R.drawable.bg_title_corner_dialog_item);
        ao.setViewTextColor(this.eFr, R.color.CAM_X0108);
        ao.setBackgroundColor(this.eTx, R.color.CAM_X0204);
        ao.setBackgroundResource(this.eTy, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.eTy, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0892a c0892a : this.mItems) {
                c0892a.onChangeSkinType();
            }
        }
        if (this.nMJ) {
            if (!StringUtils.isNull(this.titleText) && this.eFr != null && (this.eFr.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eFr.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (x.getCount(this.mItems) > 0) {
                C0892a c0892a2 = this.mItems.get(0);
                if (!c0892a2.nMN) {
                    c0892a2.nMN = true;
                    c0892a2.onChangeSkinType();
                }
            }
        }
    }

    public View bqy() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eFr.setText(this.titleText);
            this.eTx.setVisibility(0);
        } else {
            this.eFr.setVisibility(8);
            this.eTx.setVisibility(8);
        }
        if (this.nMI != null) {
            this.eTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nMI.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0892a {
        private View eSX;
        private int eSY;
        private int eSZ;
        private boolean eTb;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nML;
        private c nMM;
        public boolean nMN;

        public C0892a(a aVar) {
            this(null, aVar);
        }

        public C0892a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eSY = R.drawable.person_more_pop_item_bg_selector;
            this.eSZ = 17;
            this.eTb = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0892a.this.nMM != null) {
                        C0892a.this.nMM.onClick();
                    }
                    if (C0892a.this.nML != null && C0892a.this.nML.dTD() != null) {
                        C0892a.this.nML.dTD().k(C0892a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nML = aVar;
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
            this.nMM = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nMN) {
                    ao.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ao.ox(R.color.CAM_X0211));
                }
            }
            ao.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ao.setBackgroundColor(this.eSX, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nML != null && this.nML.getContext() != null) {
                this.mView = LayoutInflater.from(this.nML.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nML.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eSZ);
                this.eSX = this.mView.findViewById(R.id.divider_line);
                if (this.eTb) {
                    this.eSX.setVisibility(0);
                } else {
                    this.eSX.setVisibility(8);
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
