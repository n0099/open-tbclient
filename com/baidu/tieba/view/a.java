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
    private TextView dUN;
    private Context eii;
    private LinearLayout eik;
    private View eil;
    private TextView eim;
    private List<C0822a> mItems;
    private d mQF;
    private b mQG;
    private boolean mQH;
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
            this.eii = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eik = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dUN = (TextView) this.view.findViewById(R.id.title);
            this.eil = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eim = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eii;
    }

    public ViewGroup getView() {
        return this.eik;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dJb() {
        return this.mQF;
    }

    public void aX(List<C0822a> list) {
        if (list != null) {
            this.mItems = list;
            this.eik.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0822a c0822a = list.get(i2);
                    if (c0822a != null) {
                        this.eik.addView(c0822a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.mQG = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.dUN, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eil, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eim, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eim, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0822a c0822a : this.mItems) {
                c0822a.onChangeSkinType();
            }
        }
        if (this.mQH) {
            if (!StringUtils.isNull(this.titleText) && this.dUN != null && (this.dUN.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dUN.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0822a c0822a2 = this.mItems.get(0);
                if (!c0822a2.mQL) {
                    c0822a2.mQL = true;
                    c0822a2.onChangeSkinType();
                }
            }
        }
    }

    public View biq() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dUN.setText(this.titleText);
            this.eil.setVisibility(0);
        } else {
            this.dUN.setVisibility(8);
            this.eil.setVisibility(8);
        }
        if (this.mQG != null) {
            this.eim.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.mQG.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0822a {
        private View ehT;
        private int ehU;
        private int ehV;
        private boolean ehX;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private a mQJ;
        private c mQK;
        public boolean mQL;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0822a(a aVar) {
            this(null, aVar);
        }

        public C0822a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.ehU = R.drawable.person_more_pop_item_bg_selector;
            this.ehV = 17;
            this.ehX = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0822a.this.mQK != null) {
                        C0822a.this.mQK.onClick();
                    }
                    if (C0822a.this.mQJ != null && C0822a.this.mQJ.dJb() != null) {
                        C0822a.this.mQJ.dJb().k(C0822a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.mQJ = aVar;
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
            this.mQK = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.mQL) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.of(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.mQJ != null && this.mQJ.getContext() != null) {
                this.mView = LayoutInflater.from(this.mQJ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.mQJ.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.ehV);
                this.ehT = this.mView.findViewById(R.id.divider_line);
                if (this.ehX) {
                    this.ehT.setVisibility(0);
                } else {
                    this.ehT.setVisibility(8);
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
