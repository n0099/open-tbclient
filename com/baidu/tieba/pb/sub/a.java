package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.aa;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    protected View.OnClickListener bDJ;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.b.k> mData = null;
    protected View.OnClickListener bDI = null;
    protected int bDK = 0;
    protected boolean bDL = false;
    protected boolean bzz = false;
    protected boolean bDM = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bDJ = null;
        this.mContext = context;
        this.bDJ = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int hy(String str) {
        if (this.mData == null) {
            return -1;
        }
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (this.mData.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList) {
        if (arrayList == null) {
            this.mData = new ArrayList<>();
            return;
        }
        Iterator<com.baidu.tieba.tbadkCore.b.k> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.b.k next = it.next();
            if (next != null && next.getAuthor() != null) {
                next.getAuthor().setPortrait(null);
            }
        }
        this.mData = arrayList;
    }

    public void A(View.OnClickListener onClickListener) {
        this.bDI = onClickListener;
    }

    public void t(int i, boolean z) {
        this.bDK = i;
        this.bDL = z;
    }

    public void dJ(boolean z) {
        this.bzz = false;
    }

    public void dY(boolean z) {
        this.bDM = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jx();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(w.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (com.baidu.tieba.tbadkCore.b.k) getItem(i), !(!this.bDM && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View jx() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.new_sub_pb_list_item, null);
        bVar.rootView = inflate;
        bVar.bDN = (LinearLayout) inflate.findViewById(w.sub_pb_item_columnlayout);
        bVar.bDO = (TextView) inflate.findViewById(w.manage_btn);
        bVar.bzZ = (TbRichTextView) inflate.findViewById(w.new_sub_pb_list_richText);
        bVar.bzZ.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bzZ.setTextColor(ax.getColor(t.gray_day_3));
        bVar.bDO.setOnClickListener(this.bDI);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar, com.baidu.tieba.tbadkCore.b.k kVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (bVar != null && kVar != null) {
            bVar.bzZ.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (kVar.getAuthor() != null) {
                String userName = kVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                }
                sparseArray2.put(w.tag_photo_username, userName);
                sparseArray2.put(w.tag_clip_board, kVar);
                sparseArray2.put(w.tag_is_subpb, true);
            }
            bVar.bzZ.setLinkTextColor(ax.getColor(t.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a agU = kVar.agU();
            if (agU != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> zL = agU.zL();
                if (zL.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = zL.get(zL.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (zL.size() <= 1 || zL.get(zL.size() + (-2)).getType() == type) ? "  " + ba.n(kVar.getTime()) : ba.n(kVar.getTime());
                        SpannableStringBuilder zR = cVar2.zR();
                        if (agU.ajd) {
                            zR.delete(zR.length() - agU.aje, zR.length());
                        }
                        zR.append((CharSequence) str);
                        agU.ajd = true;
                        agU.aje = str.length();
                        cVar = cVar2;
                    } else if (agU.ajd) {
                        cVar = cVar2;
                    } else {
                        str = ba.n(kVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        agU.ajd = true;
                        agU.aje = str.length();
                        zL.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext);
                    }
                    SpannableStringBuilder zR2 = cVar.zR();
                    zR2.setSpan(textAppearanceSpan, zR2.length() - str.length(), zR2.length(), 33);
                }
                bVar.bzZ.setVoiceViewRes(x.voice_play_btn);
                bVar.bzZ.setIsFromCDN(this.mIsFromCDN);
                bVar.bzZ.setText(kVar.agU());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = kVar.getAuthor().getUserId();
            if (this.bDK != 0) {
                z6 = true;
                z7 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                    if (!z4 && z3) {
                        bVar.bDO.setVisibility(0);
                        bVar.bDO.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bDO.setVisibility(0);
                        bVar.bDO.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(v.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bDO.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bDO.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bDO.setTag(sparseArray);
                    }
                    if (bVar.bDO.getVisibility() == 0) {
                        sparseArray.put(w.tag_manage_user_identity, Integer.valueOf(this.bDK));
                    }
                    if (z4) {
                        sparseArray.put(w.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.tag_del_post_type, 2);
                        sparseArray.put(w.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(w.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.tag_del_post_type, 0);
                        sparseArray.put(w.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(w.tag_forbid_user_name, kVar.getAuthor().getUserName());
                        return;
                    } else {
                        sparseArray.put(w.tag_forbid_user_name, "");
                        return;
                    }
                }
                z3 = z6;
                z4 = z7;
                z5 = false;
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bDO.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bDO.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bDL) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                } else {
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = true;
                    }
                    z3 = z6;
                    z4 = z7;
                    z5 = false;
                }
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bDO.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bDO.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
