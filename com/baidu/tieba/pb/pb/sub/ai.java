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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private com.baidu.tbadk.core.data.v aTN;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.k> Xf = null;
    protected View.OnClickListener cmQ = null;
    protected int cmR = 0;
    protected boolean cmS = false;
    protected boolean cgA = false;
    protected boolean cmT = false;
    private boolean mIsFromCDN = true;

    public ai(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int jV(String str) {
        if (this.Xf == null) {
            return -1;
        }
        int size = this.Xf.size();
        for (int i = 0; i < size; i++) {
            if (this.Xf.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void e(com.baidu.tbadk.core.data.v vVar) {
        this.aTN = vVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        if (arrayList == null) {
            this.Xf = new ArrayList<>();
        } else {
            this.Xf = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cmQ = onClickListener;
    }

    public void p(int i, boolean z) {
        this.cmR = i;
        this.cmS = z;
    }

    public void eq(boolean z) {
        this.cgA = false;
    }

    public void setHasMoreData(boolean z) {
        this.cmT = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf == null) {
            return 0;
        }
        return this.Xf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xf == null || i < 0 || i >= this.Xf.size()) {
            return null;
        }
        return this.Xf.get(i);
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
            a(aVar, (com.baidu.tieba.tbadkCore.data.k) getItem(i), !(!this.cmT && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView che;
        public LinearLayout cmU;
        public TextView cmV;
        public View rootView;

        public a() {
        }
    }

    public View no() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cmU = (LinearLayout) inflate.findViewById(i.f.sub_pb_item_columnlayout);
        aVar.cmV = (TextView) inflate.findViewById(i.f.manage_btn);
        aVar.che = (TbRichTextView) inflate.findViewById(i.f.new_sub_pb_list_richText);
        aVar.che.Fq();
        aVar.che.setLineSpacing(1.0f);
        aVar.che.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.che.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.gray_day_3));
        aVar.cmV.setOnClickListener(this.cmQ);
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
            aVar.che.setPadding(0, 0, 0, 0);
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
            aVar.che.setLinkTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a awz = kVar.awz();
            if (awz != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> ET = awz.ET();
                if (ET.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = ET.get(ET.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String o = (ET.size() <= 1 || ET.get(ET.size() + (-2)).getType() == type) ? "  " + ar.o(kVar.getTime()) : ar.o(kVar.getTime());
                        SpannableStringBuilder EZ = cVar2.EZ();
                        if (awz.aBb) {
                            EZ.delete(EZ.length() - awz.aBc, EZ.length());
                        }
                        str = ar.dl(o);
                        EZ.append((CharSequence) str);
                        awz.aBb = true;
                        awz.aBc = str.length();
                        cVar = cVar2;
                    } else if (awz.aBb) {
                        cVar = cVar2;
                    } else {
                        String o2 = ar.o(kVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dl = ar.dl(o2);
                        cVar3.append(dl);
                        awz.aBb = true;
                        awz.aBc = dl.length();
                        ET.add(cVar3);
                        cVar = cVar3;
                        str = dl;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext);
                    }
                    SpannableStringBuilder EZ2 = cVar.EZ();
                    EZ2.setSpan(textAppearanceSpan, EZ2.length() - str.length(), EZ2.length(), 33);
                }
                aVar.che.setVoiceViewRes(i.g.voice_play_btn);
                aVar.che.setIsFromCDN(this.mIsFromCDN);
                aVar.che.setText(kVar.awz());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = kVar.getAuthor().getUserId();
            if (this.cmR != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cmS) {
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
                aVar.cmV.setVisibility(0);
                aVar.cmV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cmV.setVisibility(0);
                aVar.cmV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cmV.setVisibility(0);
                aVar.cmV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cmV.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cmV.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cmV.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(i.f.tag_should_manage_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cmR));
                sparseArray2.put(i.f.tag_forbid_user_name, kVar.getAuthor().getUserName());
                sparseArray2.put(i.f.tag_forbid_user_post_id, kVar.getId());
            } else {
                sparseArray2.put(i.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aTN != null) {
                    sparseArray2.put(i.f.tag_display_reply_visible, true);
                    sparseArray2.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (kVar.getAuthor() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_mute_userid, kVar.getAuthor().getUserId());
                        sparseArray2.put(i.f.tag_disable_reply_mute_username, kVar.getAuthor().getUserName());
                    }
                    if (this.aTN.getId() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_thread_id, this.aTN.getId());
                    }
                    sparseArray2.put(i.f.tag_disable_reply_post_id, kVar.getId());
                }
            } else {
                sparseArray2.put(i.f.tag_display_reply_visible, false);
            }
            if (z4) {
                sparseArray2.put(i.f.tag_should_delete_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cmR));
                sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(i.f.tag_del_post_type, 2);
                sparseArray2.put(i.f.tag_del_post_id, kVar.getId());
                return;
            }
            sparseArray2.put(i.f.tag_should_delete_visible, false);
        }
    }
}
