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
    private TextView Ti;
    private Context gXQ;
    private LinearLayout gXR;
    private View gXS;
    private TextView gXT;
    private d gXU;
    private b gXV;
    private List<C0232a> mItems;
    private String titleText;

    /* renamed from: view  reason: collision with root package name */
    private View f18view;

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
            this.gXQ = context;
            this.f18view = LayoutInflater.from(context).inflate(d.i.bottom_up_list_dialog_view, (ViewGroup) null);
            this.gXR = (LinearLayout) this.f18view.findViewById(d.g.content_view);
            this.Ti = (TextView) this.f18view.findViewById(d.g.title);
            this.gXS = this.f18view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.gXT = (TextView) this.f18view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.gXQ;
    }

    public ViewGroup ZI() {
        return this.gXR;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.gXU = dVar;
    }

    public d bzZ() {
        return this.gXU;
    }

    public void dI(List<C0232a> list) {
        if (list != null) {
            this.mItems = list;
            this.gXR.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0232a c0232a = list.get(i2);
                    if (c0232a != null) {
                        this.gXR.addView(c0232a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.gXV = bVar;
    }

    public void onChangeSkinType() {
        ak.j(this.Ti, d.C0126d.cp_bg_line_d);
        ak.h(this.Ti, d.C0126d.cp_cont_j);
        ak.j(this.gXS, d.C0126d.cp_bg_line_c);
        ak.i(this.gXT, d.f.bg_bottom_up_list_dialog_item);
        ak.h(this.gXT, d.C0126d.cp_cont_f);
        if (this.mItems != null) {
            for (C0232a c0232a : this.mItems) {
                c0232a.onChangeSkinType();
            }
        }
    }

    public View bAa() {
        if (!StringUtils.isNull(this.titleText)) {
            this.Ti.setText(this.titleText);
        } else {
            this.Ti.setVisibility(8);
        }
        if (this.gXV != null) {
            this.gXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.gXV.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.f18view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0232a {
        private String agh;
        private View dCN;
        private a gXX;
        private int gXY;
        private int gXZ;
        private c gYa;
        private boolean gYb;
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
            this.gXY = d.f.person_more_pop_item_bg_selector;
            this.gXZ = 17;
            this.gYb = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0232a.this.gYa != null) {
                        C0232a.this.gYa.onClick();
                    }
                    if (C0232a.this.gXX != null && C0232a.this.gXX.bzZ() != null) {
                        C0232a.this.gXX.bzZ().onItemClick(C0232a.this.mId);
                    }
                }
            };
            this.agh = str;
            this.gXX = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0232a(int i, String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.gXY = d.f.person_more_pop_item_bg_selector;
            this.gXZ = 17;
            this.gYb = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0232a.this.gYa != null) {
                        C0232a.this.gYa.onClick();
                    }
                    if (C0232a.this.gXX != null && C0232a.this.gXX.bzZ() != null) {
                        C0232a.this.gXX.bzZ().onItemClick(C0232a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.agh = str;
            this.gXX = aVar;
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
            this.gYa = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            ak.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            ak.h(this.mTextView, d.C0126d.cp_cont_b);
            ak.j(this.dCN, d.C0126d.cp_bg_line_c);
        }

        private void initView() {
            if (this.gXX != null && this.gXX.getContext() != null) {
                this.mView = LayoutInflater.from(this.gXX.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.gXX.ZI(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.agh);
                this.mTextView.setGravity(this.gXZ);
                this.dCN = this.mView.findViewById(d.g.divider_line);
                if (this.gYb) {
                    this.dCN.setVisibility(0);
                } else {
                    this.dCN.setVisibility(8);
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
