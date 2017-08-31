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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
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
    private bj bgI;
    protected Context mContext;
    protected ArrayList<PostData> abO = null;
    protected View.OnClickListener eWF = null;
    protected int eWG = 0;
    protected boolean eWH = false;
    protected boolean eJF = false;
    protected boolean bSL = false;
    private boolean mIsFromCDN = true;
    private boolean eWI = false;
    private boolean eVO = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pN(int i) {
        this.mSelectedPosition = i;
    }

    public int pA(String str) {
        if (this.abO == null) {
            return -1;
        }
        int size = this.abO.size();
        for (int i = 0; i < size; i++) {
            if (this.abO.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Z(bj bjVar) {
        this.bgI = bjVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abO = new ArrayList<>();
        } else {
            this.abO = arrayList;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.eWF = onClickListener;
    }

    public void z(int i, boolean z) {
        this.eWG = i;
        this.eWH = z;
    }

    public void setHasMoreData(boolean z) {
        this.bSL = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abO == null) {
            return 0;
        }
        return this.abO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abO == null || i < 0 || i >= this.abO.size()) {
            return null;
        }
        return this.abO.get(i);
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
            if (postData.getType() == PostData.gis) {
                view = aVi();
            } else {
                view = lb();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gis) {
            view = lb();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gis) {
            view = aVi();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bSL && i + 1 >= getCount();
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
        public TextView bxI;
        public TbRichTextView eGi;
        public LinearLayout eWL;
        public View eWM;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aVm;
        public TextView eWJ;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aVm = view.findViewById(d.h.divider_line);
            this.eWJ = (TextView) view.findViewById(d.h.center_reply_text);
            this.eWJ.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aVm, d.e.cp_cont_d);
                aj.i(this.eWJ, d.e.cp_cont_d);
                aj.k(this.eWJ, d.e.cp_bg_line_d);
                this.eWJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVi() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lb() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eWL = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eWI) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eWL.getLayoutParams();
            layoutParams.topMargin = k.g(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
            bVar.eWL.setLayoutParams(layoutParams);
        }
        bVar.bxI = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eGi = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eWM = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eGi.Jk();
        bVar.eGi.setSubPbPost(true);
        bVar.eGi.setTextColor(aj.getColor(d.e.cp_cont_f));
        bVar.eGi.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eGi.setTextCenter(true);
        bVar.bxI.setOnClickListener(this.eWF);
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
                aj.k(bVar.rootView, d.e.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bsp()) {
                bVar.eWM.setVisibility(0);
            } else {
                bVar.eWM.setVisibility(8);
            }
            bVar.eGi.setPadding(0, 0, 0, 0);
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
            bVar.eGi.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            bVar.eGi.setTextColor(aj.getColor(d.e.cp_cont_f));
            b(postData, this.eWI);
            TbRichText aDg = postData.aDg();
            if (aDg != null) {
                bVar.eGi.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eGi.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aDg.isChanged = true;
                }
                bVar.eGi.setText(aDg);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eWG != 0) {
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
            if (!this.eWH) {
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
            bVar.bxI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bxI.setText("");
            bVar.bxI.setContentDescription("");
            aj.i(bVar.bxI, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bxI.setVisibility(0);
                bVar.bxI.setText(this.mContext.getString(d.l.manage));
                bVar.bxI.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bxI.setVisibility(0);
                bVar.bxI.setText(this.mContext.getString(d.l.mute));
                bVar.bxI.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bxI.setVisibility(0);
                bVar.bxI.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.bxI.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bxI.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bxI.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eWG));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bgI != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bgI.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bgI.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eWG));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eWI && z2 && this.eVO) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eWL.getLayoutParams();
                layoutParams.topMargin = k.g(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eWL.setLayoutParams(layoutParams);
            }
            if (this.eWI && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eWL.getLayoutParams();
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eWL.setLayoutParams(layoutParams2);
            }
            if (this.eWI) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), k.g(this.mContext, d.f.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText aDg;
        SpannableStringBuilder IC;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder IC2;
        if (postData != null && (aDg = postData.aDg()) != null) {
            ArrayList<TbRichTextData> Iv = aDg.Iv();
            if (!v.v(Iv)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Iv.get(Iv.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (Iv.size() > 1) {
                            if ((Iv.get(Iv.size() + (-2)) != null ? Iv.get(Iv.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                IC2 = tbRichTextData2.IC();
                                if (aDg.hasAppendTime && IC2 != 0 && aDg.appendLength <= IC2.length()) {
                                    IC2.delete(IC2.length() - aDg.appendLength, IC2.length());
                                }
                                String dT = am.dT(str2);
                                if (IC2 != null) {
                                    IC2.append((CharSequence) dT);
                                }
                                aDg.hasAppendTime = true;
                                aDg.appendLength = dT.length();
                                tbRichTextData = tbRichTextData2;
                                str = dT;
                            }
                        }
                        str2 = str3;
                        IC2 = tbRichTextData2.IC();
                        if (aDg.hasAppendTime) {
                            IC2.delete(IC2.length() - aDg.appendLength, IC2.length());
                        }
                        String dT2 = am.dT(str2);
                        if (IC2 != null) {
                        }
                        aDg.hasAppendTime = true;
                        aDg.appendLength = dT2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dT2;
                    } else if (aDg.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dT(r);
                        tbRichTextData.append(str);
                        aDg.hasAppendTime = true;
                        aDg.appendLength = str.length();
                        Iv.add(tbRichTextData);
                    }
                    SpannableStringBuilder IC3 = tbRichTextData.IC();
                    if (IC3 != null && str.length() <= IC3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.e.cp_cont_d));
                        IC3.setSpan(absoluteSizeSpan, IC3.length() - str.length(), IC3.length(), 33);
                        IC3.setSpan(foregroundColorSpan, IC3.length() - str.length(), IC3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Iv.get(Iv.size() - 1);
                if (aDg.hasAppendTime && tbRichTextData3 != null && (IC = tbRichTextData3.IC()) != null && aDg.appendLength <= IC.length()) {
                    IC.delete(IC.length() - aDg.appendLength, IC.length());
                }
                aDg.hasAppendTime = false;
                aDg.appendLength = 0;
            }
        }
    }

    public void kb(boolean z) {
        this.eWI = z;
    }

    public void kc(boolean z) {
        this.eVO = z;
    }

    public void pB(String str) {
        this.mPostId = str;
    }
}
