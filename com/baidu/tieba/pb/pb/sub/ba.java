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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends BaseAdapter {
    private bi aRV;
    protected Context mContext;
    protected ArrayList<PostData> abn = null;
    protected View.OnClickListener etH = null;
    protected int etI = 0;
    protected boolean etJ = false;
    protected boolean ekE = false;
    protected boolean bAP = false;
    private boolean mIsFromCDN = true;
    private boolean etK = false;
    private boolean esT = false;
    private String mPostId = "";
    private int cjm = -1;

    public ba(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void oy(int i) {
        this.cjm = i;
    }

    public int nO(String str) {
        if (this.abn == null) {
            return -1;
        }
        int size = this.abn.size();
        for (int i = 0; i < size; i++) {
            if (this.abn.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(bi biVar) {
        this.aRV = biVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abn = new ArrayList<>();
        } else {
            this.abn = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.etH = onClickListener;
    }

    public void B(int i, boolean z) {
        this.etI = i;
        this.etJ = z;
    }

    public void setHasMoreData(boolean z) {
        this.bAP = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abn == null) {
            return 0;
        }
        return this.abn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abn == null || i < 0 || i >= this.abn.size()) {
            return null;
        }
        return this.abn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.fvY) {
                view = aOL();
            } else {
                view = le();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.fvY) {
            view = le();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.fvY) {
            view = aOL();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(w.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bAP && i + 1 >= getCount();
            boolean z2 = i == this.cjm;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.cjm = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TbRichTextView ehF;
        public LinearLayout etN;
        public TextView etO;
        public View etP;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aTU;
        public TextView etL;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aTU = view.findViewById(w.h.divider_line);
            this.etL = (TextView) view.findViewById(w.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                com.baidu.tbadk.core.util.aq.k(this.aTU, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.i(this.etL, w.e.cp_cont_d);
                com.baidu.tbadk.core.util.aq.k(this.etL, w.e.cp_bg_line_d);
                this.etL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.aq.x(i, w.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aOL() {
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View le() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(w.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.etN = (LinearLayout) inflate.findViewById(w.h.sub_pb_item_columnlayout);
        if (this.etK) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.etN.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
            bVar.etN.setLayoutParams(layoutParams);
        }
        bVar.etO = (TextView) inflate.findViewById(w.h.manage_btn);
        bVar.ehF = (TbRichTextView) inflate.findViewById(w.h.new_sub_pb_list_richText);
        bVar.etP = inflate.findViewById(w.h.divide_bottom_view);
        bVar.ehF.Jc();
        bVar.ehF.setSubPbPost(true);
        bVar.ehF.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        bVar.ehF.setTextCenter(true);
        bVar.etO.setOnClickListener(this.etH);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && postData != null) {
            if (z3) {
                com.baidu.tbadk.core.util.aq.k(bVar.rootView, w.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bip()) {
                bVar.etP.setVisibility(0);
            } else {
                bVar.etP.setVisibility(8);
            }
            bVar.ehF.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String userName = postData.getAuthor().getUserName();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(w.h.tag_photo_username, userName);
                sparseArray.put(w.h.tag_photo_userid, userId);
                sparseArray.put(w.h.tag_clip_board, postData);
                sparseArray.put(w.h.tag_is_subpb, true);
            }
            bVar.ehF.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
            bVar.ehF.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
            a(postData, this.etK);
            TbRichText awl = postData.awl();
            if (awl != null) {
                bVar.ehF.setVoiceViewRes(w.j.voice_play_btn_new);
                bVar.ehF.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    awl.isChanged = true;
                }
                bVar.ehF.setText(awl);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.etI != 0) {
                boolean z9 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = true;
                    z5 = false;
                } else {
                    z5 = z9;
                    z4 = true;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (!this.etJ) {
                z6 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                z4 = true;
            } else {
                z6 = false;
                z4 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z7 = false;
                z8 = z4;
            } else {
                z7 = true;
                z8 = true;
            }
            bVar.etO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.etO.setText("");
            bVar.etO.setContentDescription("");
            com.baidu.tbadk.core.util.aq.i(bVar.etO, w.e.cp_link_tip_c);
            if (z5) {
                bVar.etO.setVisibility(0);
                bVar.etO.setText(this.mContext.getString(w.l.manage));
                bVar.etO.setContentDescription(this.mContext.getString(w.l.manage));
            } else if (z6) {
                bVar.etO.setVisibility(0);
                bVar.etO.setText(this.mContext.getString(w.l.mute));
                bVar.etO.setContentDescription(this.mContext.getString(w.l.mute));
            } else if (z8) {
                bVar.etO.setVisibility(0);
                bVar.etO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_pb_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                bVar.etO.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.etO.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.etO.setTag(sparseArray2);
            }
            sparseArray2.put(w.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(w.h.tag_should_manage_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.etI));
                sparseArray2.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(w.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.aRV != null) {
                    sparseArray2.put(w.h.tag_user_mute_visible, true);
                    sparseArray2.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.aRV.getId() != null) {
                        sparseArray2.put(w.h.tag_user_mute_thread_id, this.aRV.getId());
                    }
                    sparseArray2.put(w.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(w.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(w.h.tag_should_delete_visible, true);
                sparseArray2.put(w.h.tag_manage_user_identity, Integer.valueOf(this.etI));
                sparseArray2.put(w.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(w.h.tag_del_post_type, 2);
                sparseArray2.put(w.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(w.h.tag_should_delete_visible, false);
            }
            if (this.etK && z2 && this.esT) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.etN.getLayoutParams();
                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds32);
                layoutParams.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.etN.setLayoutParams(layoutParams);
            }
            if (this.etK && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.etN.getLayoutParams();
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8);
                bVar.etN.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds12));
            bVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText awl;
        SpannableStringBuilder Iv;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Iv2;
        if (postData != null && (awl = postData.awl()) != null) {
            ArrayList<TbRichTextData> Io = awl.Io();
            if (!com.baidu.tbadk.core.util.x.q(Io)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Io.get(Io.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + com.baidu.tbadk.core.util.au.q(postData.getTime());
                        if (Io.size() > 1) {
                            if ((Io.get(Io.size() + (-2)) != null ? Io.get(Io.size() - 2).getType() : -1) != type) {
                                str2 = com.baidu.tbadk.core.util.au.q(postData.getTime());
                                Iv2 = tbRichTextData2.Iv();
                                if (awl.hasAppendTime && Iv2 != 0 && awl.appendLength <= Iv2.length()) {
                                    Iv2.delete(Iv2.length() - awl.appendLength, Iv2.length());
                                }
                                String dz = com.baidu.tbadk.core.util.au.dz(str2);
                                if (Iv2 != null) {
                                    Iv2.append((CharSequence) dz);
                                }
                                awl.hasAppendTime = true;
                                awl.appendLength = dz.length();
                                tbRichTextData = tbRichTextData2;
                                str = dz;
                            }
                        }
                        str2 = str3;
                        Iv2 = tbRichTextData2.Iv();
                        if (awl.hasAppendTime) {
                            Iv2.delete(Iv2.length() - awl.appendLength, Iv2.length());
                        }
                        String dz2 = com.baidu.tbadk.core.util.au.dz(str2);
                        if (Iv2 != null) {
                        }
                        awl.hasAppendTime = true;
                        awl.appendLength = dz2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dz2;
                    } else if (awl.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String q = com.baidu.tbadk.core.util.au.q(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = com.baidu.tbadk.core.util.au.dz(q);
                        tbRichTextData.append(str);
                        awl.hasAppendTime = true;
                        awl.appendLength = str.length();
                        Io.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, w.m.subtext_entelechy);
                    }
                    SpannableStringBuilder Iv3 = tbRichTextData.Iv();
                    if (Iv3 != null && str.length() <= Iv3.length()) {
                        Iv3.setSpan(textAppearanceSpan, Iv3.length() - str.length(), Iv3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Io.get(Io.size() - 1);
                if (awl.hasAppendTime && tbRichTextData3 != null && (Iv = tbRichTextData3.Iv()) != null && awl.appendLength <= Iv.length()) {
                    Iv.delete(Iv.length() - awl.appendLength, Iv.length());
                }
                awl.hasAppendTime = false;
                awl.appendLength = 0;
            }
        }
    }

    public void iZ(boolean z) {
        this.etK = z;
    }

    public void ja(boolean z) {
        this.esT = z;
    }

    public void nP(String str) {
        this.mPostId = str;
    }
}
