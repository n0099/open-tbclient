package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private com.baidu.tbadk.core.data.w aTY;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.k> Xh = null;
    protected View.OnClickListener cnb = null;
    protected int cnc = 0;
    protected boolean cnd = false;
    protected boolean cgL = false;
    protected boolean cne = false;
    private boolean mIsFromCDN = true;

    public ai(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int jV(String str) {
        if (this.Xh == null) {
            return -1;
        }
        int size = this.Xh.size();
        for (int i = 0; i < size; i++) {
            if (this.Xh.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void e(com.baidu.tbadk.core.data.w wVar) {
        this.aTY = wVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        if (arrayList == null) {
            this.Xh = new ArrayList<>();
        } else {
            this.Xh = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cnb = onClickListener;
    }

    public void p(int i, boolean z) {
        this.cnc = i;
        this.cnd = z;
    }

    public void eq(boolean z) {
        this.cgL = false;
    }

    public void setHasMoreData(boolean z) {
        this.cne = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xh == null) {
            return 0;
        }
        return this.Xh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xh == null || i < 0 || i >= this.Xh.size()) {
            return null;
        }
        return this.Xh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = no();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(i.f.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.k) getItem(i), !(!this.cne && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView chp;
        public LinearLayout cnf;
        public TextView cng;
        public View rootView;

        public a() {
        }
    }

    public View no() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cnf = (LinearLayout) inflate.findViewById(i.f.sub_pb_item_columnlayout);
        aVar.cng = (TextView) inflate.findViewById(i.f.manage_btn);
        aVar.chp = (TbRichTextView) inflate.findViewById(i.f.new_sub_pb_list_richText);
        aVar.chp.Fm();
        aVar.chp.setLineSpacing(1.0f);
        aVar.chp.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.chp.setTextColor(an.getColor(i.c.gray_day_3));
        aVar.cng.setOnClickListener(this.cnb);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.k kVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && kVar != null) {
            aVar.chp.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (kVar.getAuthor() != null) {
                String userName = kVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(i.f.tag_photo_username, userName);
                sparseArray.put(i.f.tag_clip_board, kVar);
                sparseArray.put(i.f.tag_is_subpb, true);
            }
            aVar.chp.setLinkTextColor(an.getColor(i.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a awF = kVar.awF();
            if (awF != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> EP = awF.EP();
                if (EP.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = EP.get(EP.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String m = (EP.size() <= 1 || EP.get(EP.size() + (-2)).getType() == type) ? "  " + as.m(kVar.getTime()) : as.m(kVar.getTime());
                        SpannableStringBuilder EV = cVar2.EV();
                        if (awF.aBm) {
                            EV.delete(EV.length() - awF.aBn, EV.length());
                        }
                        str = as.dm(m);
                        EV.append((CharSequence) str);
                        awF.aBm = true;
                        awF.aBn = str.length();
                        cVar = cVar2;
                    } else if (awF.aBm) {
                        cVar = cVar2;
                    } else {
                        String m2 = as.m(kVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dm = as.dm(m2);
                        cVar3.append(dm);
                        awF.aBm = true;
                        awF.aBn = dm.length();
                        EP.add(cVar3);
                        cVar = cVar3;
                        str = dm;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext);
                    }
                    SpannableStringBuilder EV2 = cVar.EV();
                    EV2.setSpan(textAppearanceSpan, EV2.length() - str.length(), EV2.length(), 33);
                }
                aVar.chp.setVoiceViewRes(i.g.voice_play_btn);
                aVar.chp.setIsFromCDN(this.mIsFromCDN);
                aVar.chp.setText(kVar.awF());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = kVar.getAuthor().getUserId();
            if (this.cnc != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cnd) {
                z3 = false;
            } else if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
                z6 = true;
            } else {
                z3 = false;
                z6 = true;
            }
            if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = z6;
            } else {
                z4 = true;
                z7 = true;
            }
            if (z5) {
                aVar.cng.setVisibility(0);
                aVar.cng.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cng.setVisibility(0);
                aVar.cng.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cng.setVisibility(0);
                aVar.cng.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cng.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cng.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cng.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(i.f.tag_should_manage_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cnc));
                sparseArray2.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                sparseArray2.put(i.f.tag_forbid_user_post_id, kVar.getId());
            } else {
                sparseArray2.put(i.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aTY != null) {
                    sparseArray2.put(i.f.tag_display_reply_visible, true);
                    sparseArray2.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (kVar.getAuthor() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                        sparseArray2.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                    }
                    if (this.aTY.getId() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_thread_id, this.aTY.getId());
                    }
                    sparseArray2.put(i.f.tag_disable_reply_post_id, kVar.getId());
                }
            } else {
                sparseArray2.put(i.f.tag_display_reply_visible, false);
            }
            if (z4) {
                sparseArray2.put(i.f.tag_should_delete_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cnc));
                sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(i.f.tag_del_post_type, 2);
                sparseArray2.put(i.f.tag_del_post_id, kVar.getId());
                return;
            }
            sparseArray2.put(i.f.tag_should_delete_visible, false);
        }
    }
}
