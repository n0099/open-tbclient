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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private bl bgF;
    protected Context mContext;
    protected ArrayList<PostData> acF = null;
    protected View.OnClickListener eWb = null;
    protected int eWc = 0;
    protected boolean eWd = false;
    protected boolean eJy = false;
    protected boolean bPi = false;
    private boolean mIsFromCDN = true;
    private boolean eWe = false;
    private boolean eVn = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pA(int i) {
        this.mSelectedPosition = i;
    }

    public int pH(String str) {
        if (this.acF == null) {
            return -1;
        }
        int size = this.acF.size();
        for (int i = 0; i < size; i++) {
            if (this.acF.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void U(bl blVar) {
        this.bgF = blVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acF = new ArrayList<>();
        } else {
            this.acF = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.eWb = onClickListener;
    }

    public void C(int i, boolean z) {
        this.eWc = i;
        this.eWd = z;
    }

    public void setHasMoreData(boolean z) {
        this.bPi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acF == null) {
            return 0;
        }
        return this.acF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acF == null || i < 0 || i >= this.acF.size()) {
            return null;
        }
        return this.acF.get(i);
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
            if (postData.getType() == PostData.ghX) {
                view = aVs();
            } else {
                view = lk();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.ghX) {
            view = lk();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.ghX) {
            view = aVs();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bPi && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView bwg;
        public TbRichTextView eFT;
        public LinearLayout eWh;
        public View eWi;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aVB;
        public TextView eWf;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aVB = view.findViewById(d.h.divider_line);
            this.eWf = (TextView) view.findViewById(d.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ai.k(this.aVB, d.e.cp_cont_d);
                ai.i(this.eWf, d.e.cp_cont_d);
                ai.k(this.eWf, d.e.cp_bg_line_d);
                this.eWf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.v(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVs() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lk() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eWh = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eWe) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eWh.getLayoutParams();
            layoutParams.topMargin = k.g(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
            bVar.eWh.setLayoutParams(layoutParams);
        }
        bVar.bwg = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eFT = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eWi = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eFT.Jc();
        bVar.eFT.setSubPbPost(true);
        bVar.eFT.setTextColor(ai.getColor(d.e.cp_cont_f));
        bVar.eFT.setTextCenter(true);
        bVar.bwg.setOnClickListener(this.eWb);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_holder, bVar);
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
                ai.k(bVar.rootView, d.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bsz()) {
                bVar.eWi.setVisibility(0);
            } else {
                bVar.eWi.setVisibility(8);
            }
            bVar.eFT.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_photo_username, name_show);
                sparseArray.put(d.h.tag_photo_userid, userId);
                sparseArray.put(d.h.tag_clip_board, postData);
                sparseArray.put(d.h.tag_is_subpb, true);
            }
            bVar.eFT.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            bVar.eFT.setTextColor(ai.getColor(d.e.cp_cont_f));
            a(postData, this.eWe);
            TbRichText aAP = postData.aAP();
            if (aAP != null) {
                bVar.eFT.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eFT.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aAP.isChanged = true;
                }
                bVar.eFT.setText(aAP);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eWc != 0) {
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
            if (!this.eWd) {
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
            bVar.bwg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bwg.setText("");
            bVar.bwg.setContentDescription("");
            ai.i(bVar.bwg, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bwg.setVisibility(0);
                bVar.bwg.setText(this.mContext.getString(d.l.manage));
                bVar.bwg.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bwg.setVisibility(0);
                bVar.bwg.setText(this.mContext.getString(d.l.mute));
                bVar.bwg.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bwg.setVisibility(0);
                bVar.bwg.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.bwg.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bwg.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bwg.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eWc));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bgF != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bgF.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bgF.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eWc));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eWe && z2 && this.eVn) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eWh.getLayoutParams();
                layoutParams.topMargin = k.g(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eWh.setLayoutParams(layoutParams);
            }
            if (this.eWe && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eWh.getLayoutParams();
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eWh.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), k.g(this.mContext, d.f.ds10));
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aAP;
        SpannableStringBuilder Iu;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Iu2;
        if (postData != null && (aAP = postData.aAP()) != null) {
            ArrayList<TbRichTextData> Io = aAP.Io();
            if (!u.v(Io)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Io.get(Io.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + al.r(postData.getTime());
                        if (Io.size() > 1) {
                            if ((Io.get(Io.size() + (-2)) != null ? Io.get(Io.size() - 2).getType() : -1) != type) {
                                str2 = al.r(postData.getTime());
                                Iu2 = tbRichTextData2.Iu();
                                if (aAP.hasAppendTime && Iu2 != 0 && aAP.appendLength <= Iu2.length()) {
                                    Iu2.delete(Iu2.length() - aAP.appendLength, Iu2.length());
                                }
                                String dX = al.dX(str2);
                                if (Iu2 != null) {
                                    Iu2.append((CharSequence) dX);
                                }
                                aAP.hasAppendTime = true;
                                aAP.appendLength = dX.length();
                                tbRichTextData = tbRichTextData2;
                                str = dX;
                            }
                        }
                        str2 = str3;
                        Iu2 = tbRichTextData2.Iu();
                        if (aAP.hasAppendTime) {
                            Iu2.delete(Iu2.length() - aAP.appendLength, Iu2.length());
                        }
                        String dX2 = al.dX(str2);
                        if (Iu2 != null) {
                        }
                        aAP.hasAppendTime = true;
                        aAP.appendLength = dX2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dX2;
                    } else if (aAP.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = al.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = al.dX(r);
                        tbRichTextData.append(str);
                        aAP.hasAppendTime = true;
                        aAP.appendLength = str.length();
                        Io.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy);
                    }
                    SpannableStringBuilder Iu3 = tbRichTextData.Iu();
                    if (Iu3 != null && str.length() <= Iu3.length()) {
                        Iu3.setSpan(textAppearanceSpan, Iu3.length() - str.length(), Iu3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Io.get(Io.size() - 1);
                if (aAP.hasAppendTime && tbRichTextData3 != null && (Iu = tbRichTextData3.Iu()) != null && aAP.appendLength <= Iu.length()) {
                    Iu.delete(Iu.length() - aAP.appendLength, Iu.length());
                }
                aAP.hasAppendTime = false;
                aAP.appendLength = 0;
            }
        }
    }

    public void jZ(boolean z) {
        this.eWe = z;
    }

    public void ka(boolean z) {
        this.eVn = z;
    }

    public void pI(String str) {
        this.mPostId = str;
    }
}
