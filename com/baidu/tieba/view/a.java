package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView Tm;
    private Context gWP;
    private LinearLayout gWQ;
    private View gWR;
    private TextView gWS;
    private d gWT;
    private b gWU;
    private List<C0232a> mItems;
    private String titleText;

    /* renamed from: view  reason: collision with root package name */
    private View f21view;

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
        void onItemClick(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.gWP = context;
            this.f21view = LayoutInflater.from(context).inflate(d.i.bottom_up_list_dialog_view, (ViewGroup) null);
            this.gWQ = (LinearLayout) this.f21view.findViewById(d.g.content_view);
            this.Tm = (TextView) this.f21view.findViewById(d.g.title);
            this.gWR = this.f21view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.gWS = (TextView) this.f21view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.gWP;
    }

    public ViewGroup ZF() {
        return this.gWQ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.gWT = dVar;
    }

    public d bAb() {
        return this.gWT;
    }

    public void dF(List<C0232a> list) {
        if (list != null) {
            this.mItems = list;
            this.gWQ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0232a c0232a = list.get(i2);
                    if (c0232a != null) {
                        this.gWQ.addView(c0232a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gWU = bVar;
    }

    public void onChangeSkinType() {
        ak.j(this.Tm, d.C0126d.cp_bg_line_d);
        ak.h(this.Tm, d.C0126d.cp_cont_j);
        ak.j(this.gWR, d.C0126d.cp_bg_line_c);
        ak.i(this.gWS, d.f.bg_bottom_up_list_dialog_item);
        ak.h(this.gWS, d.C0126d.cp_cont_f);
        if (this.mItems != null) {
            for (C0232a c0232a : this.mItems) {
                c0232a.onChangeSkinType();
            }
        }
    }

    public View bAc() {
        if (!StringUtils.isNull(this.titleText)) {
            this.Tm.setText(this.titleText);
        } else {
            this.Tm.setVisibility(8);
        }
        if (this.gWU != null) {
            this.gWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.gWU.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.f21view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0232a {
        private String agh;
        private View dBJ;
        private a gWW;
        private int gWX;
        private int gWY;
        private c gWZ;
        private boolean gXa;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0232a(a aVar) {
            this(null, aVar);
        }

        public C0232a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.gWX = d.f.person_more_pop_item_bg_selector;
            this.gWY = 17;
            this.gXa = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0232a.this.gWZ != null) {
                        C0232a.this.gWZ.onClick();
                    }
                    if (C0232a.this.gWW != null && C0232a.this.gWW.bAb() != null) {
                        C0232a.this.gWW.bAb().onItemClick(C0232a.this.mId);
                    }
                }
            };
            this.agh = str;
            this.gWW = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0232a(int i, String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.gWX = d.f.person_more_pop_item_bg_selector;
            this.gWY = 17;
            this.gXa = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0232a.this.gWZ != null) {
                        C0232a.this.gWZ.onClick();
                    }
                    if (C0232a.this.gWW != null && C0232a.this.gWW.bAb() != null) {
                        C0232a.this.gWW.bAb().onItemClick(C0232a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.agh = str;
            this.gWW = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.agh = str;
            this.mTextView.setText(this.agh);
        }

        public void a(c cVar) {
            this.gWZ = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ak.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            ak.h(this.mTextView, d.C0126d.cp_cont_b);
            ak.j(this.dBJ, d.C0126d.cp_bg_line_c);
        }

        private void initView() {
            if (this.gWW != null && this.gWW.getContext() != null) {
                this.mView = LayoutInflater.from(this.gWW.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.gWW.ZF(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.agh);
                this.mTextView.setGravity(this.gWY);
                this.dBJ = this.mView.findViewById(d.g.divider_line);
                if (this.gXa) {
                    this.dBJ.setVisibility(0);
                } else {
                    this.dBJ.setVisibility(8);
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
