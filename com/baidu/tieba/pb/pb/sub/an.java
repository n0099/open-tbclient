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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends BaseAdapter {
    private as bks;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.s> Xq = null;
    protected View.OnClickListener dpk = null;
    protected int dpl = 0;
    protected boolean dpm = false;
    protected boolean ddp = false;
    protected boolean aXX = false;
    private boolean mIsFromCDN = true;

    public an(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int mh(String str) {
        if (this.Xq == null) {
            return -1;
        }
        int size = this.Xq.size();
        for (int i = 0; i < size; i++) {
            if (this.Xq.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(as asVar) {
        this.bks = asVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (arrayList == null) {
            this.Xq = new ArrayList<>();
        } else {
            this.Xq = arrayList;
        }
    }

    public void N(View.OnClickListener onClickListener) {
        this.dpk = onClickListener;
    }

    public void t(int i, boolean z) {
        this.dpl = i;
        this.dpm = z;
    }

    public void fR(boolean z) {
        this.ddp = false;
    }

    public void setHasMoreData(boolean z) {
        this.aXX = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq == null) {
            return 0;
        }
        return this.Xq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xq == null || i < 0 || i >= this.Xq.size()) {
            return null;
        }
        return this.Xq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mZ();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(t.g.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.s) getItem(i), !(!this.aXX && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAh;
        public TbRichTextView ddA;
        public LinearLayout dpn;
        public TextView dpo;

        public a() {
        }
    }

    public View mZ() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.aAh = inflate;
        aVar.dpn = (LinearLayout) inflate.findViewById(t.g.sub_pb_item_columnlayout);
        aVar.dpo = (TextView) inflate.findViewById(t.g.manage_btn);
        aVar.ddA = (TbRichTextView) inflate.findViewById(t.g.new_sub_pb_list_richText);
        aVar.ddA.IY();
        aVar.ddA.setLineSpacing(1.0f);
        aVar.ddA.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.ddA.setTextColor(at.getColor(t.d.gray_day_3));
        aVar.dpo.setOnClickListener(this.dpk);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && sVar != null) {
            aVar.ddA.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (sVar.getAuthor() != null) {
                String userName = sVar.getAuthor().getUserName();
                String userId = sVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.aAh.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.aAh.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_photo_username, userName);
                sparseArray.put(t.g.tag_photo_userid, userId);
                sparseArray.put(t.g.tag_clip_board, sVar);
                sparseArray.put(t.g.tag_is_subpb, true);
            }
            aVar.ddA.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a amn = sVar.amn();
            if (amn != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Im = amn.Im();
                if (Im.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Im.get(Im.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String w = (Im.size() <= 1 || Im.get(Im.size() + (-2)).getType() == type) ? "  " + ay.w(sVar.getTime()) : ay.w(sVar.getTime());
                        SpannableStringBuilder Is = cVar2.Is();
                        if (amn.aHP) {
                            Is.delete(Is.length() - amn.aHQ, Is.length());
                        }
                        str = ay.dz(w);
                        Is.append((CharSequence) str);
                        amn.aHP = true;
                        amn.aHQ = str.length();
                        cVar = cVar2;
                    } else if (amn.aHP) {
                        cVar = cVar2;
                    } else {
                        String w2 = ay.w(sVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dz = ay.dz(w2);
                        cVar3.append(dz);
                        amn.aHP = true;
                        amn.aHQ = dz.length();
                        Im.add(cVar3);
                        cVar = cVar3;
                        str = dz;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext);
                    }
                    SpannableStringBuilder Is2 = cVar.Is();
                    Is2.setSpan(textAppearanceSpan, Is2.length() - str.length(), Is2.length(), 33);
                }
                aVar.ddA.setVoiceViewRes(t.h.voice_play_btn);
                aVar.ddA.setIsFromCDN(this.mIsFromCDN);
                aVar.ddA.setText(sVar.amn());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId2 = sVar.getAuthor().getUserId();
            if (this.dpl != 0) {
                z5 = true;
                z6 = true;
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.dpm) {
                z3 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
                z6 = true;
            } else {
                z3 = false;
                z6 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = z6;
            } else {
                z4 = true;
                z7 = true;
            }
            if (z5) {
                aVar.dpo.setVisibility(0);
                aVar.dpo.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aVar.dpo.setContentDescription(this.mContext.getString(t.j.manage));
            } else if (z3) {
                aVar.dpo.setVisibility(0);
                aVar.dpo.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
                aVar.dpo.setContentDescription(this.mContext.getString(t.j.mute));
            } else if (z4) {
                aVar.dpo.setVisibility(0);
                aVar.dpo.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                aVar.dpo.setContentDescription(this.mContext.getString(t.j.delete));
            } else {
                aVar.dpo.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.dpo.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.dpo.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(t.g.tag_should_manage_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dpl));
                sparseArray2.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                sparseArray2.put(t.g.tag_forbid_user_post_id, sVar.getId());
            } else {
                sparseArray2.put(t.g.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.bks != null) {
                    sparseArray2.put(t.g.tag_user_mute_visible, true);
                    sparseArray2.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (sVar.getAuthor() != null) {
                        sparseArray2.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                        sparseArray2.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                    }
                    if (this.bks.getId() != null) {
                        sparseArray2.put(t.g.tag_user_mute_thread_id, this.bks.getId());
                    }
                    sparseArray2.put(t.g.tag_user_mute_post_id, sVar.getId());
                }
            } else {
                sparseArray2.put(t.g.tag_user_mute_visible, false);
            }
            if (z4) {
                sparseArray2.put(t.g.tag_should_delete_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dpl));
                sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(t.g.tag_del_post_type, 2);
                sparseArray2.put(t.g.tag_del_post_id, sVar.getId());
                return;
            }
            sparseArray2.put(t.g.tag_should_delete_visible, false);
        }
    }
}
