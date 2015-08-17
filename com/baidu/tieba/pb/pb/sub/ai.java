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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private com.baidu.tbadk.core.data.v aUA;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.i> Xe = null;
    protected View.OnClickListener cgx = null;
    protected int cgy = 0;
    protected boolean cgz = false;
    protected boolean cbF = false;
    protected boolean cgA = false;
    private boolean mIsFromCDN = true;

    public ai(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int js(String str) {
        if (this.Xe == null) {
            return -1;
        }
        int size = this.Xe.size();
        for (int i = 0; i < size; i++) {
            if (this.Xe.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void d(com.baidu.tbadk.core.data.v vVar) {
        this.aUA = vVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.i> arrayList) {
        if (arrayList == null) {
            this.Xe = new ArrayList<>();
        } else {
            this.Xe = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cgx = onClickListener;
    }

    public void n(int i, boolean z) {
        this.cgy = i;
        this.cgz = z;
    }

    public void ei(boolean z) {
        this.cbF = false;
    }

    public void setHasMoreData(boolean z) {
        this.cgA = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xe == null || i < 0 || i >= this.Xe.size()) {
            return null;
        }
        return this.Xe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = nq();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(i.f.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.i) getItem(i), !(!this.cgA && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView cdc;
        public LinearLayout cgB;
        public TextView cgC;
        public View rootView;

        public a() {
        }
    }

    public View nq() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cgB = (LinearLayout) inflate.findViewById(i.f.sub_pb_item_columnlayout);
        aVar.cgC = (TextView) inflate.findViewById(i.f.manage_btn);
        aVar.cdc = (TbRichTextView) inflate.findViewById(i.f.new_sub_pb_list_richText);
        aVar.cdc.Fs();
        aVar.cdc.setLineSpacing(1.0f);
        aVar.cdc.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.cdc.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.gray_day_3));
        aVar.cgC.setOnClickListener(this.cgx);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.i iVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && iVar != null) {
            aVar.cdc.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (iVar.getAuthor() != null) {
                String userName = iVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(i.f.tag_photo_username, userName);
                sparseArray.put(i.f.tag_clip_board, iVar);
                sparseArray.put(i.f.tag_is_subpb, true);
            }
            aVar.cdc.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a apW = iVar.apW();
            if (apW != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> EW = apW.EW();
                if (EW.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = EW.get(EW.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String m = (EW.size() <= 1 || EW.get(EW.size() + (-2)).getType() == type) ? "  " + aq.m(iVar.getTime()) : aq.m(iVar.getTime());
                        SpannableStringBuilder Fc = cVar2.Fc();
                        if (apW.aBa) {
                            Fc.delete(Fc.length() - apW.aBb, Fc.length());
                        }
                        str = aq.db(m);
                        Fc.append((CharSequence) str);
                        apW.aBa = true;
                        apW.aBb = str.length();
                        cVar = cVar2;
                    } else if (apW.aBa) {
                        cVar = cVar2;
                    } else {
                        String m2 = aq.m(iVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String db = aq.db(m2);
                        cVar3.append(db);
                        apW.aBa = true;
                        apW.aBb = db.length();
                        EW.add(cVar3);
                        cVar = cVar3;
                        str = db;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.j.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.j.subtext);
                    }
                    SpannableStringBuilder Fc2 = cVar.Fc();
                    Fc2.setSpan(textAppearanceSpan, Fc2.length() - str.length(), Fc2.length(), 33);
                }
                aVar.cdc.setVoiceViewRes(i.g.voice_play_btn);
                aVar.cdc.setIsFromCDN(this.mIsFromCDN);
                aVar.cdc.setText(iVar.apW());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = iVar.getAuthor().getUserId();
            if (this.cgy != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cgz) {
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
                aVar.cgC.setVisibility(0);
                aVar.cgC.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cgC.setVisibility(0);
                aVar.cgC.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cgC.setVisibility(0);
                aVar.cgC.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cgC.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cgC.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cgC.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(i.f.tag_should_manage_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgy));
                sparseArray2.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                sparseArray2.put(i.f.tag_forbid_user_post_id, iVar.getId());
            } else {
                sparseArray2.put(i.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aUA != null) {
                    sparseArray2.put(i.f.tag_display_reply_visible, true);
                    sparseArray2.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (iVar.getAuthor() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_mute_userid, iVar.getAuthor().getUserId());
                        sparseArray2.put(i.f.tag_disable_reply_mute_username, iVar.getAuthor().getUserName());
                    }
                    if (this.aUA.getId() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_thread_id, this.aUA.getId());
                    }
                    sparseArray2.put(i.f.tag_disable_reply_post_id, iVar.getId());
                }
            } else {
                sparseArray2.put(i.f.tag_display_reply_visible, false);
            }
            if (z4) {
                sparseArray2.put(i.f.tag_should_delete_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cgy));
                sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(i.f.tag_del_post_type, 2);
                sparseArray2.put(i.f.tag_del_post_id, iVar.getId());
                return;
            }
            sparseArray2.put(i.f.tag_should_delete_visible, false);
        }
    }
}
