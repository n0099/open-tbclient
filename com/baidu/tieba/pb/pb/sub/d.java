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
    protected ArrayList<PostData> acH = null;
    protected View.OnClickListener eXU = null;
    protected int eXV = 0;
    protected boolean eXW = false;
    protected boolean eLs = false;
    protected boolean bPR = false;
    private boolean mIsFromCDN = true;
    private boolean eXX = false;
    private boolean eXg = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pK(int i) {
        this.mSelectedPosition = i;
    }

    public int pJ(String str) {
        if (this.acH == null) {
            return -1;
        }
        int size = this.acH.size();
        for (int i = 0; i < size; i++) {
            if (this.acH.get(i).getId().equals(str)) {
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
            this.acH = new ArrayList<>();
        } else {
            this.acH = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.eXU = onClickListener;
    }

    public void C(int i, boolean z) {
        this.eXV = i;
        this.eXW = z;
    }

    public void setHasMoreData(boolean z) {
        this.bPR = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acH == null) {
            return 0;
        }
        return this.acH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acH == null || i < 0 || i >= this.acH.size()) {
            return null;
        }
        return this.acH.get(i);
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
            if (postData.getType() == PostData.gjQ) {
                view = aVZ();
            } else {
                view = lk();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gjQ) {
            view = lk();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gjQ) {
            view = aVZ();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bPR && i + 1 >= getCount();
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
        public TextView bwP;
        public TbRichTextView eHN;
        public LinearLayout eYa;
        public View eYb;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aVC;
        public TextView eXY;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aVC = view.findViewById(d.h.divider_line);
            this.eXY = (TextView) view.findViewById(d.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ai.k(this.aVC, d.e.cp_cont_d);
                ai.i(this.eXY, d.e.cp_cont_d);
                ai.k(this.eXY, d.e.cp_bg_line_d);
                this.eXY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.v(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVZ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lk() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eYa = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eXX) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eYa.getLayoutParams();
            layoutParams.topMargin = k.g(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
            bVar.eYa.setLayoutParams(layoutParams);
        }
        bVar.bwP = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eHN = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eYb = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eHN.Jc();
        bVar.eHN.setSubPbPost(true);
        bVar.eHN.setTextColor(ai.getColor(d.e.cp_cont_f));
        bVar.eHN.setTextCenter(true);
        bVar.bwP.setOnClickListener(this.eXU);
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
            if (postData.bth()) {
                bVar.eYb.setVisibility(0);
            } else {
                bVar.eYb.setVisibility(8);
            }
            bVar.eHN.setPadding(0, 0, 0, 0);
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
            bVar.eHN.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            bVar.eHN.setTextColor(ai.getColor(d.e.cp_cont_f));
            a(postData, this.eXX);
            TbRichText aBw = postData.aBw();
            if (aBw != null) {
                bVar.eHN.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eHN.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aBw.isChanged = true;
                }
                bVar.eHN.setText(aBw);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eXV != 0) {
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
            if (!this.eXW) {
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
            bVar.bwP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bwP.setText("");
            bVar.bwP.setContentDescription("");
            ai.i(bVar.bwP, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bwP.setVisibility(0);
                bVar.bwP.setText(this.mContext.getString(d.l.manage));
                bVar.bwP.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bwP.setVisibility(0);
                bVar.bwP.setText(this.mContext.getString(d.l.mute));
                bVar.bwP.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bwP.setVisibility(0);
                bVar.bwP.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.bwP.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bwP.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bwP.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXV));
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
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXV));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eXX && z2 && this.eXg) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eYa.getLayoutParams();
                layoutParams.topMargin = k.g(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eYa.setLayoutParams(layoutParams);
            }
            if (this.eXX && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eYa.getLayoutParams();
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eYa.setLayoutParams(layoutParams2);
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
        TbRichText aBw;
        SpannableStringBuilder Iu;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Iu2;
        if (postData != null && (aBw = postData.aBw()) != null) {
            ArrayList<TbRichTextData> Io = aBw.Io();
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
                                if (aBw.hasAppendTime && Iu2 != 0 && aBw.appendLength <= Iu2.length()) {
                                    Iu2.delete(Iu2.length() - aBw.appendLength, Iu2.length());
                                }
                                String dX = al.dX(str2);
                                if (Iu2 != null) {
                                    Iu2.append((CharSequence) dX);
                                }
                                aBw.hasAppendTime = true;
                                aBw.appendLength = dX.length();
                                tbRichTextData = tbRichTextData2;
                                str = dX;
                            }
                        }
                        str2 = str3;
                        Iu2 = tbRichTextData2.Iu();
                        if (aBw.hasAppendTime) {
                            Iu2.delete(Iu2.length() - aBw.appendLength, Iu2.length());
                        }
                        String dX2 = al.dX(str2);
                        if (Iu2 != null) {
                        }
                        aBw.hasAppendTime = true;
                        aBw.appendLength = dX2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dX2;
                    } else if (aBw.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = al.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = al.dX(r);
                        tbRichTextData.append(str);
                        aBw.hasAppendTime = true;
                        aBw.appendLength = str.length();
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
                if (aBw.hasAppendTime && tbRichTextData3 != null && (Iu = tbRichTextData3.Iu()) != null && aBw.appendLength <= Iu.length()) {
                    Iu.delete(Iu.length() - aBw.appendLength, Iu.length());
                }
                aBw.hasAppendTime = false;
                aBw.appendLength = 0;
            }
        }
    }

    public void kc(boolean z) {
        this.eXX = z;
    }

    public void kd(boolean z) {
        this.eXg = z;
    }

    public void pK(String str) {
        this.mPostId = str;
    }
}
