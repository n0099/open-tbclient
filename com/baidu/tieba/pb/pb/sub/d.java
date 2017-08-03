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
    private bl bfu;
    protected Context mContext;
    protected ArrayList<PostData> abi = null;
    protected View.OnClickListener eUO = null;
    protected int eUP = 0;
    protected boolean eUQ = false;
    protected boolean eIl = false;
    protected boolean bNY = false;
    private boolean mIsFromCDN = true;
    private boolean eUR = false;
    private boolean eUa = false;
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

    public int pC(String str) {
        if (this.abi == null) {
            return -1;
        }
        int size = this.abi.size();
        for (int i = 0; i < size; i++) {
            if (this.abi.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void U(bl blVar) {
        this.bfu = blVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abi = new ArrayList<>();
        } else {
            this.abi = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.eUO = onClickListener;
    }

    public void B(int i, boolean z) {
        this.eUP = i;
        this.eUQ = z;
    }

    public void setHasMoreData(boolean z) {
        this.bNY = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abi == null) {
            return 0;
        }
        return this.abi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abi == null || i < 0 || i >= this.abi.size()) {
            return null;
        }
        return this.abi.get(i);
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
            if (postData.getType() == PostData.ggM) {
                view = aVh();
            } else {
                view = la();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.ggM) {
            view = la();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.ggM) {
            view = aVh();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bNY && i + 1 >= getCount();
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
        public TextView buW;
        public TbRichTextView eEG;
        public LinearLayout eUU;
        public View eUV;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aUp;
        public TextView eUS;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aUp = view.findViewById(d.h.divider_line);
            this.eUS = (TextView) view.findViewById(d.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ai.k(this.aUp, d.e.cp_cont_d);
                ai.i(this.eUS, d.e.cp_cont_d);
                ai.k(this.eUS, d.e.cp_bg_line_d);
                this.eUS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.u(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVh() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View la() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eUU = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eUR) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eUU.getLayoutParams();
            layoutParams.topMargin = k.g(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
            bVar.eUU.setLayoutParams(layoutParams);
        }
        bVar.buW = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eEG = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eUV = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eEG.IV();
        bVar.eEG.setSubPbPost(true);
        bVar.eEG.setTextColor(ai.getColor(d.e.cp_cont_f));
        bVar.eEG.setTextCenter(true);
        bVar.buW.setOnClickListener(this.eUO);
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
            if (postData.bss()) {
                bVar.eUV.setVisibility(0);
            } else {
                bVar.eUV.setVisibility(8);
            }
            bVar.eEG.setPadding(0, 0, 0, 0);
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
            bVar.eEG.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            bVar.eEG.setTextColor(ai.getColor(d.e.cp_cont_f));
            a(postData, this.eUR);
            TbRichText aAE = postData.aAE();
            if (aAE != null) {
                bVar.eEG.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eEG.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aAE.isChanged = true;
                }
                bVar.eEG.setText(aAE);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eUP != 0) {
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
            if (!this.eUQ) {
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
            bVar.buW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.buW.setText("");
            bVar.buW.setContentDescription("");
            ai.i(bVar.buW, d.e.cp_link_tip_c);
            if (z5) {
                bVar.buW.setVisibility(0);
                bVar.buW.setText(this.mContext.getString(d.l.manage));
                bVar.buW.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.buW.setVisibility(0);
                bVar.buW.setText(this.mContext.getString(d.l.mute));
                bVar.buW.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.buW.setVisibility(0);
                bVar.buW.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.buW.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.buW.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.buW.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eUP));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bfu != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bfu.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bfu.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eUP));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eUR && z2 && this.eUa) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eUU.getLayoutParams();
                layoutParams.topMargin = k.g(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eUU.setLayoutParams(layoutParams);
            }
            if (this.eUR && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eUU.getLayoutParams();
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eUU.setLayoutParams(layoutParams2);
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
        TbRichText aAE;
        SpannableStringBuilder In;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder In2;
        if (postData != null && (aAE = postData.aAE()) != null) {
            ArrayList<TbRichTextData> Ig = aAE.Ig();
            if (!u.v(Ig)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Ig.get(Ig.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + al.r(postData.getTime());
                        if (Ig.size() > 1) {
                            if ((Ig.get(Ig.size() + (-2)) != null ? Ig.get(Ig.size() - 2).getType() : -1) != type) {
                                str2 = al.r(postData.getTime());
                                In2 = tbRichTextData2.In();
                                if (aAE.hasAppendTime && In2 != 0 && aAE.appendLength <= In2.length()) {
                                    In2.delete(In2.length() - aAE.appendLength, In2.length());
                                }
                                String dR = al.dR(str2);
                                if (In2 != null) {
                                    In2.append((CharSequence) dR);
                                }
                                aAE.hasAppendTime = true;
                                aAE.appendLength = dR.length();
                                tbRichTextData = tbRichTextData2;
                                str = dR;
                            }
                        }
                        str2 = str3;
                        In2 = tbRichTextData2.In();
                        if (aAE.hasAppendTime) {
                            In2.delete(In2.length() - aAE.appendLength, In2.length());
                        }
                        String dR2 = al.dR(str2);
                        if (In2 != null) {
                        }
                        aAE.hasAppendTime = true;
                        aAE.appendLength = dR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dR2;
                    } else if (aAE.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = al.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = al.dR(r);
                        tbRichTextData.append(str);
                        aAE.hasAppendTime = true;
                        aAE.appendLength = str.length();
                        Ig.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy);
                    }
                    SpannableStringBuilder In3 = tbRichTextData.In();
                    if (In3 != null && str.length() <= In3.length()) {
                        In3.setSpan(textAppearanceSpan, In3.length() - str.length(), In3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Ig.get(Ig.size() - 1);
                if (aAE.hasAppendTime && tbRichTextData3 != null && (In = tbRichTextData3.In()) != null && aAE.appendLength <= In.length()) {
                    In.delete(In.length() - aAE.appendLength, In.length());
                }
                aAE.hasAppendTime = false;
                aAE.appendLength = 0;
            }
        }
    }

    public void jZ(boolean z) {
        this.eUR = z;
    }

    public void ka(boolean z) {
        this.eUa = z;
    }

    public void pD(String str) {
        this.mPostId = str;
    }
}
