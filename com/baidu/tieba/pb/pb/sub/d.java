package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private bh biZ;
    protected Context mContext;
    protected ArrayList<PostData> acc = null;
    protected View.OnClickListener fax = null;
    protected int fay = 0;
    protected boolean faz = false;
    protected boolean faA = false;
    protected boolean caT = false;
    private boolean mIsFromCDN = true;
    private boolean faB = false;
    private boolean eZK = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qd(int i) {
        this.mSelectedPosition = i;
    }

    public int pT(String str) {
        if (this.acc == null) {
            return -1;
        }
        int size = this.acc.size();
        for (int i = 0; i < size; i++) {
            if (this.acc.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void M(bh bhVar) {
        this.biZ = bhVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acc = new ArrayList<>();
        } else {
            this.acc = arrayList;
        }
    }

    public void F(View.OnClickListener onClickListener) {
        this.fax = onClickListener;
    }

    public void z(int i, boolean z) {
        this.fay = i;
        this.faz = z;
    }

    public void setHasMoreData(boolean z) {
        this.caT = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acc == null) {
            return 0;
        }
        return this.acc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acc == null || i < 0 || i >= this.acc.size()) {
            return null;
        }
        return this.acc.get(i);
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
            if (postData.getType() == PostData.gqs) {
                view = aWH();
            } else {
                view = kX();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gqs) {
            view = kX();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gqs) {
            view = aWH();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.caT && i + 1 >= getCount();
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
        public TextView bGV;
        public TbRichTextView eII;
        public LinearLayout faE;
        public View faF;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aXj;
        public TextView faC;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aXj = view.findViewById(d.g.divider_line);
            this.faC = (TextView) view.findViewById(d.g.center_reply_text);
            this.faC.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aXj, d.C0080d.cp_cont_d);
                aj.i(this.faC, d.C0080d.cp_cont_d);
                aj.k(this.faC, d.C0080d.cp_bg_line_d);
                this.faC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aWH() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kX() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.faE = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.faB) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.faE.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
            bVar.faE.setLayoutParams(layoutParams);
        }
        bVar.bGV = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.eII = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.faF = inflate.findViewById(d.g.divide_bottom_view);
        bVar.eII.getLayoutStrategy().IS();
        bVar.eII.setSubPbPost(true);
        bVar.eII.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
        bVar.eII.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eII.setTextCenter(true);
        bVar.bGV.setOnClickListener(this.fax);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
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
                aj.k(bVar.rootView, d.C0080d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.buH()) {
                bVar.faF.setVisibility(0);
            } else {
                bVar.faF.setVisibility(8);
            }
            bVar.eII.setPadding(0, 0, 0, 0);
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                String userId = postData.rt().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_photo_username, name_show);
                sparseArray.put(d.g.tag_photo_userid, userId);
                sparseArray.put(d.g.tag_clip_board, postData);
                sparseArray.put(d.g.tag_is_subpb, true);
            }
            bVar.eII.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            bVar.eII.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
            a(postData, this.faB);
            TbRichText aEx = postData.aEx();
            if (aEx != null) {
                bVar.eII.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.eII.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aEx.isChanged = true;
                }
                bVar.eII.setText(aEx);
            }
            String userId2 = postData.rt().getUserId();
            if (this.fay != 0) {
                boolean z9 = this.fay != 1002;
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
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
            if (!this.faz) {
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
            bVar.bGV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bGV.setText("");
            bVar.bGV.setContentDescription("");
            aj.i(bVar.bGV, d.C0080d.cp_link_tip_c);
            if (z5) {
                bVar.bGV.setVisibility(0);
                bVar.bGV.setText(this.mContext.getString(d.j.manage));
                bVar.bGV.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.bGV.setVisibility(0);
                bVar.bGV.setText(this.mContext.getString(d.j.mute));
                bVar.bGV.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.bGV.setVisibility(0);
                if (this.fay == 1002 && !z7) {
                    bVar.bGV.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.bGV.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.bGV.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bGV.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bGV.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fay));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.biZ != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rt() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                    }
                    if (this.biZ.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.biZ.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fay));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.faB && z2 && this.eZK) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.faE.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.faE.setLayoutParams(layoutParams);
            }
            if (this.faB && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.faE.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.faE.setLayoutParams(layoutParams2);
            }
            if (this.faB) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), l.f(this.mContext, d.e.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aEx;
        SpannableStringBuilder Ja;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Ja2;
        if (postData != null && (aEx = postData.aEx()) != null) {
            ArrayList<TbRichTextData> IT = aEx.IT();
            if (!v.v(IT)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = IT.get(IT.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (IT.size() > 1) {
                            if ((IT.get(IT.size() + (-2)) != null ? IT.get(IT.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                Ja2 = tbRichTextData2.Ja();
                                if (aEx.hasAppendTime && Ja2 != 0 && aEx.appendLength <= Ja2.length()) {
                                    Ja2.delete(Ja2.length() - aEx.appendLength, Ja2.length());
                                }
                                String dR = am.dR(str2);
                                if (Ja2 != null) {
                                    Ja2.append((CharSequence) dR);
                                }
                                aEx.hasAppendTime = true;
                                aEx.appendLength = dR.length();
                                tbRichTextData = tbRichTextData2;
                                str = dR;
                            }
                        }
                        str2 = str3;
                        Ja2 = tbRichTextData2.Ja();
                        if (aEx.hasAppendTime) {
                            Ja2.delete(Ja2.length() - aEx.appendLength, Ja2.length());
                        }
                        String dR2 = am.dR(str2);
                        if (Ja2 != null) {
                        }
                        aEx.hasAppendTime = true;
                        aEx.appendLength = dR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dR2;
                    } else if (aEx.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dR(r);
                        tbRichTextData.append(str);
                        aEx.hasAppendTime = true;
                        aEx.appendLength = str.length();
                        IT.add(tbRichTextData);
                    }
                    SpannableStringBuilder Ja3 = tbRichTextData.Ja();
                    if (Ja3 != null && str.length() <= Ja3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_d));
                        Ja3.setSpan(absoluteSizeSpan, Ja3.length() - str.length(), Ja3.length(), 33);
                        Ja3.setSpan(foregroundColorSpan, Ja3.length() - str.length(), Ja3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = IT.get(IT.size() - 1);
                if (aEx.hasAppendTime && tbRichTextData3 != null && (Ja = tbRichTextData3.Ja()) != null && aEx.appendLength <= Ja.length()) {
                    Ja.delete(Ja.length() - aEx.appendLength, Ja.length());
                }
                aEx.hasAppendTime = false;
                aEx.appendLength = 0;
            }
        }
    }

    public void jP(boolean z) {
        this.faB = z;
    }

    public void jQ(boolean z) {
        this.eZK = z;
    }

    public void pU(String str) {
        this.mPostId = str;
    }
}
