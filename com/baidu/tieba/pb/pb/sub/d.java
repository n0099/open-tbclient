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
    private bh bie;
    protected Context mContext;
    protected ArrayList<PostData> abD = null;
    protected View.OnClickListener eRu = null;
    protected int eRv = 0;
    protected boolean eRw = false;
    protected boolean eDL = false;
    protected boolean bTc = false;
    private boolean mIsFromCDN = true;
    private boolean eRx = false;
    private boolean eQD = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pJ(int i) {
        this.mSelectedPosition = i;
    }

    public int pk(String str) {
        if (this.abD == null) {
            return -1;
        }
        int size = this.abD.size();
        for (int i = 0; i < size; i++) {
            if (this.abD.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void U(bh bhVar) {
        this.bie = bhVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abD = new ArrayList<>();
        } else {
            this.abD = arrayList;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        this.eRu = onClickListener;
    }

    public void x(int i, boolean z) {
        this.eRv = i;
        this.eRw = z;
    }

    public void setHasMoreData(boolean z) {
        this.bTc = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abD == null) {
            return 0;
        }
        return this.abD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abD == null || i < 0 || i >= this.abD.size()) {
            return null;
        }
        return this.abD.get(i);
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
            if (postData.getType() == PostData.ggD) {
                view = aTx();
            } else {
                view = ld();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.ggD) {
            view = ld();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.ggD) {
            view = aTx();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bTc && i + 1 >= getCount();
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
        public TextView bAj;
        public TbRichTextView eAm;
        public LinearLayout eRA;
        public View eRB;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aWK;
        public TextView eRy;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aWK = view.findViewById(d.h.divider_line);
            this.eRy = (TextView) view.findViewById(d.h.center_reply_text);
            this.eRy.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aWK, d.e.cp_cont_d);
                aj.i(this.eRy, d.e.cp_cont_d);
                aj.k(this.eRy, d.e.cp_bg_line_d);
                this.eRy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aTx() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View ld() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eRA = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eRx) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eRA.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.f.ds8);
            bVar.eRA.setLayoutParams(layoutParams);
        }
        bVar.bAj = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eAm = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eRB = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eAm.Jn();
        bVar.eAm.setSubPbPost(true);
        bVar.eAm.setTextColor(aj.getColor(d.e.cp_cont_f));
        bVar.eAm.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eAm.setTextCenter(true);
        bVar.bAj.setOnClickListener(this.eRu);
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
            if (postData.brr()) {
                bVar.eRB.setVisibility(0);
            } else {
                bVar.eRB.setVisibility(8);
            }
            bVar.eAm.setPadding(0, 0, 0, 0);
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
            bVar.eAm.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            bVar.eAm.setTextColor(aj.getColor(d.e.cp_cont_f));
            a(postData, this.eRx);
            TbRichText aBY = postData.aBY();
            if (aBY != null) {
                bVar.eAm.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eAm.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aBY.isChanged = true;
                }
                bVar.eAm.setText(aBY);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eRv != 0) {
                boolean z9 = this.eRv != 1002;
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
            if (!this.eRw) {
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
            bVar.bAj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bAj.setText("");
            bVar.bAj.setContentDescription("");
            aj.i(bVar.bAj, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bAj.setVisibility(0);
                bVar.bAj.setText(this.mContext.getString(d.l.manage));
                bVar.bAj.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bAj.setVisibility(0);
                bVar.bAj.setText(this.mContext.getString(d.l.mute));
                bVar.bAj.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bAj.setVisibility(0);
                if (this.eRv == 1002 && !z7) {
                    bVar.bAj.setText(this.mContext.getString(d.l.report_text));
                } else {
                    bVar.bAj.setText(this.mContext.getString(d.l.delete));
                }
            } else {
                bVar.bAj.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bAj.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bAj.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eRv));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bie != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bie.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bie.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eRv));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eRx && z2 && this.eQD) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eRA.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.f.ds8);
                bVar.eRA.setLayoutParams(layoutParams);
            }
            if (this.eRx && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eRA.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.f.ds8);
                bVar.eRA.setLayoutParams(layoutParams2);
            }
            if (this.eRx) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), l.f(this.mContext, d.f.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aBY;
        SpannableStringBuilder IE;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder IE2;
        if (postData != null && (aBY = postData.aBY()) != null) {
            ArrayList<TbRichTextData> Ix = aBY.Ix();
            if (!v.u(Ix)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Ix.get(Ix.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (Ix.size() > 1) {
                            if ((Ix.get(Ix.size() + (-2)) != null ? Ix.get(Ix.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                IE2 = tbRichTextData2.IE();
                                if (aBY.hasAppendTime && IE2 != 0 && aBY.appendLength <= IE2.length()) {
                                    IE2.delete(IE2.length() - aBY.appendLength, IE2.length());
                                }
                                String dL = am.dL(str2);
                                if (IE2 != null) {
                                    IE2.append((CharSequence) dL);
                                }
                                aBY.hasAppendTime = true;
                                aBY.appendLength = dL.length();
                                tbRichTextData = tbRichTextData2;
                                str = dL;
                            }
                        }
                        str2 = str3;
                        IE2 = tbRichTextData2.IE();
                        if (aBY.hasAppendTime) {
                            IE2.delete(IE2.length() - aBY.appendLength, IE2.length());
                        }
                        String dL2 = am.dL(str2);
                        if (IE2 != null) {
                        }
                        aBY.hasAppendTime = true;
                        aBY.appendLength = dL2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dL2;
                    } else if (aBY.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dL(r);
                        tbRichTextData.append(str);
                        aBY.hasAppendTime = true;
                        aBY.appendLength = str.length();
                        Ix.add(tbRichTextData);
                    }
                    SpannableStringBuilder IE3 = tbRichTextData.IE();
                    if (IE3 != null && str.length() <= IE3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.e.cp_cont_d));
                        IE3.setSpan(absoluteSizeSpan, IE3.length() - str.length(), IE3.length(), 33);
                        IE3.setSpan(foregroundColorSpan, IE3.length() - str.length(), IE3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Ix.get(Ix.size() - 1);
                if (aBY.hasAppendTime && tbRichTextData3 != null && (IE = tbRichTextData3.IE()) != null && aBY.appendLength <= IE.length()) {
                    IE.delete(IE.length() - aBY.appendLength, IE.length());
                }
                aBY.hasAppendTime = false;
                aBY.appendLength = 0;
            }
        }
    }

    public void jQ(boolean z) {
        this.eRx = z;
    }

    public void jR(boolean z) {
        this.eQD = z;
    }

    public void pl(String str) {
        this.mPostId = str;
    }
}
