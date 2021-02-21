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
    private TextView eHx;
    private Context eVI;
    private LinearLayout eVK;
    private View eVN;
    private TextView eVO;
    private List<C0897a> mItems;
    private d nWZ;
    private b nXa;
    private boolean nXb;
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
            this.eVI = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eVK = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.eHx = (TextView) this.view.findViewById(R.id.title);
            this.eVN = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eVO = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eVI;
    }

    public ViewGroup getView() {
        return this.eVK;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dVX() {
        return this.nWZ;
    }

    public void bw(List<C0897a> list) {
        if (list != null) {
            this.mItems = list;
            this.eVK.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0897a c0897a = list.get(i2);
                    if (c0897a != null) {
                        this.eVK.addView(c0897a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nXa = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eHx, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0108);
        ap.setBackgroundColor(this.eVN, R.color.CAM_X0204);
        ap.setBackgroundResource(this.eVO, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eVO, R.color.CAM_X0107);
        if (this.mItems != null) {
            for (C0897a c0897a : this.mItems) {
                c0897a.onChangeSkinType();
            }
        }
        if (this.nXb) {
            if (!StringUtils.isNull(this.titleText) && this.eHx != null && (this.eHx.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.eHx.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0897a c0897a2 = this.mItems.get(0);
                if (!c0897a2.nXf) {
                    c0897a2.nXf = true;
                    c0897a2.onChangeSkinType();
                }
            }
        }
    }

    public View bqR() {
        if (!StringUtils.isNull(this.titleText)) {
            this.eHx.setText(this.titleText);
            this.eVN.setVisibility(0);
        } else {
            this.eHx.setVisibility(8);
            this.eVN.setVisibility(8);
        }
        if (this.nXa != null) {
            this.eVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nXa.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0897a {
        private View eVm;
        private String mText;
        public TextView mTextView;
        private View mView;
        private a nXd;
        private c nXe;
        public boolean nXf;
        private int mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        private int eVn = R.drawable.person_more_pop_item_bg_selector;
        private int eVo = 17;
        private boolean eVq = true;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0897a.this.nXe != null) {
                    C0897a.this.nXe.onClick();
                }
                if (C0897a.this.nXd != null && C0897a.this.nXd.dVX() != null) {
                    C0897a.this.nXd.dVX().k(C0897a.this.mId, view);
                }
            }
        };
        private int mId = hashCode();

        public C0897a(String str, a aVar) {
            this.mText = str;
            this.nXd = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void a(c cVar) {
            this.nXe = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nXf) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.oC(R.color.CAM_X0211));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.CAM_X0105);
            ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        }

        private void initView() {
            if (this.nXd != null && this.nXd.getContext() != null) {
                this.mView = LayoutInflater.from(this.nXd.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nXd.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eVo);
                this.eVm = this.mView.findViewById(R.id.divider_line);
                if (this.eVq) {
                    this.eVm.setVisibility(0);
                } else {
                    this.eVm.setVisibility(8);
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
