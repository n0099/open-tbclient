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
    private com.baidu.tbadk.core.data.x aUP;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.i> Xn = null;
    protected View.OnClickListener chu = null;
    protected int chv = 0;
    protected boolean chw = false;
    protected boolean ccA = false;
    protected boolean chx = false;
    private boolean mIsFromCDN = true;

    public ai(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int jA(String str) {
        if (this.Xn == null) {
            return -1;
        }
        int size = this.Xn.size();
        for (int i = 0; i < size; i++) {
            if (this.Xn.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void e(com.baidu.tbadk.core.data.x xVar) {
        this.aUP = xVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.i> arrayList) {
        if (arrayList == null) {
            this.Xn = new ArrayList<>();
        } else {
            this.Xn = arrayList;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.chu = onClickListener;
    }

    public void o(int i, boolean z) {
        this.chv = i;
        this.chw = z;
    }

    public void ep(boolean z) {
        this.ccA = false;
    }

    public void setHasMoreData(boolean z) {
        this.chx = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn == null) {
            return 0;
        }
        return this.Xn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xn == null || i < 0 || i >= this.Xn.size()) {
            return null;
        }
        return this.Xn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = nn();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(i.f.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.i) getItem(i), !(!this.chx && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView cdZ;
        public LinearLayout chy;
        public TextView chz;
        public View rootView;

        public a() {
        }
    }

    public View nn() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.chy = (LinearLayout) inflate.findViewById(i.f.sub_pb_item_columnlayout);
        aVar.chz = (TextView) inflate.findViewById(i.f.manage_btn);
        aVar.cdZ = (TbRichTextView) inflate.findViewById(i.f.new_sub_pb_list_richText);
        aVar.cdZ.FC();
        aVar.cdZ.setLineSpacing(1.0f);
        aVar.cdZ.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.cdZ.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.gray_day_3));
        aVar.chz.setOnClickListener(this.chu);
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
            aVar.cdZ.setPadding(0, 0, 0, 0);
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
            aVar.cdZ.setLinkTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a auk = iVar.auk();
            if (auk != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Fg = auk.Fg();
                if (Fg.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Fg.get(Fg.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String m = (Fg.size() <= 1 || Fg.get(Fg.size() + (-2)).getType() == type) ? "  " + aq.m(iVar.getTime()) : aq.m(iVar.getTime());
                        SpannableStringBuilder Fm = cVar2.Fm();
                        if (auk.aCI) {
                            Fm.delete(Fm.length() - auk.aCJ, Fm.length());
                        }
                        str = aq.dh(m);
                        Fm.append((CharSequence) str);
                        auk.aCI = true;
                        auk.aCJ = str.length();
                        cVar = cVar2;
                    } else if (auk.aCI) {
                        cVar = cVar2;
                    } else {
                        String m2 = aq.m(iVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dh = aq.dh(m2);
                        cVar3.append(dh);
                        auk.aCI = true;
                        auk.aCJ = dh.length();
                        Fg.add(cVar3);
                        cVar = cVar3;
                        str = dh;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext);
                    }
                    SpannableStringBuilder Fm2 = cVar.Fm();
                    Fm2.setSpan(textAppearanceSpan, Fm2.length() - str.length(), Fm2.length(), 33);
                }
                aVar.cdZ.setVoiceViewRes(i.g.voice_play_btn);
                aVar.cdZ.setIsFromCDN(this.mIsFromCDN);
                aVar.cdZ.setText(iVar.auk());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = iVar.getAuthor().getUserId();
            if (this.chv != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.chw) {
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
                aVar.chz.setVisibility(0);
                aVar.chz.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.chz.setVisibility(0);
                aVar.chz.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.chz.setVisibility(0);
                aVar.chz.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.chz.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.chz.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.chz.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(i.f.tag_should_manage_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chv));
                sparseArray2.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                sparseArray2.put(i.f.tag_forbid_user_post_id, iVar.getId());
            } else {
                sparseArray2.put(i.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aUP != null) {
                    sparseArray2.put(i.f.tag_display_reply_visible, true);
                    sparseArray2.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (iVar.getAuthor() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_mute_userid, iVar.getAuthor().getUserId());
                        sparseArray2.put(i.f.tag_disable_reply_mute_username, iVar.getAuthor().getUserName());
                    }
                    if (this.aUP.getId() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_thread_id, this.aUP.getId());
                    }
                    sparseArray2.put(i.f.tag_disable_reply_post_id, iVar.getId());
                }
            } else {
                sparseArray2.put(i.f.tag_display_reply_visible, false);
            }
            if (z4) {
                sparseArray2.put(i.f.tag_should_delete_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.chv));
                sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(i.f.tag_del_post_type, 2);
                sparseArray2.put(i.f.tag_del_post_id, iVar.getId());
                return;
            }
            sparseArray2.put(i.f.tag_should_delete_visible, false);
        }
    }
}
