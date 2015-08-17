package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.r;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class i implements u, ad {
    public static final BdUniqueId cIF = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String cIH;
    private ArrayList<i> cIJ;
    private ArrayList<i> cIM;
    private int cIO;
    private com.baidu.tbadk.data.a cIP;
    private com.baidu.tbadk.data.d cIQ;
    private SmallTailInfo cgV;
    private HashMap<String, MetaData> userMap;
    private boolean cIK = false;
    private com.baidu.tbadk.widget.richText.a cIN = null;
    private boolean cIR = false;
    private String id = null;
    private String title = null;
    private int cIG = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<b> bKW = new ArrayList<>();
    private ArrayList<b> bLD = new ArrayList<>();
    private int cII = 0;
    private int cIL = 0;
    private int VX = 0;

    public i() {
        this.cIJ = null;
        this.cIM = null;
        this.cIJ = new ArrayList<>();
        this.cIM = new ArrayList<>();
    }

    public ArrayList<i> apS() {
        return this.cIJ;
    }

    public void apT() {
        this.cII--;
    }

    public void jH(int i) {
        this.cII = i;
    }

    public ArrayList<i> apU() {
        return this.cIM;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int apV() {
        return this.cIG;
    }

    public void jI(int i) {
        this.cIG = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a apW() {
        return this.cIN;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a apX() {
        return this.cIP;
    }

    public SmallTailInfo afz() {
        return this.cgV;
    }

    public void c(SmallTailInfo smallTailInfo) {
        this.cgV = smallTailInfo;
    }

    public com.baidu.tbadk.data.d apY() {
        return this.cIQ;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        r rVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cq;
        if (this.cIN != null && this.cIN.EW() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new j(this, it.next(), bdUniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(i.d.small_icon_height));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            a aVar = new a(TbadkCoreApplication.m411getInst().getApp(), str, str2);
            if (z && (cq = al.cq(i.e.icon_floorhost)) != null) {
                int width = (cq.getWidth() * dimensionPixelSize) / cq.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cq);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.i iVar = new com.baidu.tbadk.widget.i(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(iVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(iVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> EW = this.cIN.EW();
            if (EW != null && EW.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = EW.get(0);
                if (cVar2.Fc() != null) {
                    cVar2.ey(sb.length());
                    cVar2.Fc().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= EW.size()) {
                        rVar = null;
                        break;
                    } else if (EW.get(i4) == null || EW.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        r Fd = EW.get(i4).Fd();
                        EW.remove(i4);
                        rVar = Fd;
                        break;
                    }
                }
                if (rVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(rVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.ey(sb.length());
                cVar.append(spannableString);
                EW.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap nc;
        if (aVar == null || (nc = aVar.nc()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nc);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_height));
        return bitmapDrawable;
    }

    public int apZ() {
        return this.cII;
    }

    public int aqa() {
        return this.cIL;
    }

    public void aP(Context context) {
        int type;
        int i;
        int i2;
        if (this.bKW != null) {
            int i3 = -1;
            int size = this.bLD.size();
            if (size > 0) {
                try {
                    i3 = this.bLD.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bKW.size()) {
                b bVar = this.bKW.get(i4);
                if (b.ax(i5, bVar.getType())) {
                    this.bLD.get(size - 1).a(bVar.aO(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (bVar.getType() == 3 || bVar.getType() == 2 || bVar.getType() == 11) {
                        this.bLD.add(bVar);
                        type = bVar.getType();
                    } else {
                        b bVar2 = new b();
                        bVar2.setType(0);
                        bVar2.a(bVar.aO(context));
                        this.bLD.add(bVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void aQ(Context context) {
        try {
            if (this.cIN != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cIN.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bLD == null || this.bLD.size() == 0) {
                aP(context);
            }
            ArrayList<b> arrayList = this.bLD;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<b> it = arrayList.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.getType() == 0) {
                        if (next.apE() != null) {
                            sb.append((CharSequence) next.apE());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(i.C0057i.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(i.C0057i.voice_str));
                    } else if (next.getType() == 2) {
                        String eB = TbFaceManager.Cd().eB(next.getText());
                        if (eB != null) {
                            sb.append("[");
                            sb.append(eB);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.apD())) {
                        sb.append("[").append(next.apD()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.cIG = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cIN = TbRichTextView.b(context, subPostList.content, z);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.cIG = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.cIH = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.cII = post.sub_post_number.intValue();
                this.cIL = post.add_post_number.intValue();
                this.cIN = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            i iVar = new i();
                            iVar.cIR = subPostList.is_giftpost.intValue() == 1;
                            iVar.setUserMap(this.userMap);
                            iVar.a(subPostList, context);
                            this.cIJ.add(iVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            i iVar2 = new i();
                            iVar2.setUserMap(this.userMap);
                            iVar2.a(subPostList2, context);
                            this.cIM.add(iVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.cIM.size() >= 5) {
                    this.cIO = 5;
                } else {
                    this.cIO = this.cIM.size();
                }
                if (post.tail_info != null) {
                    this.cIP = new com.baidu.tbadk.data.a();
                    this.cIP.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cIQ = new com.baidu.tbadk.data.d();
                    this.cIQ.a(post.lbs_info);
                }
                this.VX = post.storecount.intValue();
                if (post.signature != null) {
                    this.cgV = new SmallTailInfo();
                    this.cgV.id = post.signature.signature_id.intValue();
                    this.cgV.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cgV.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cgV.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends ClickableSpan {
        private Context mContext;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mContext = null;
            this.mName = str;
            this.mId = str2;
            this.mContext = context;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.mContext != null) {
                textPaint.setColor(al.getColor(i.c.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mContext, this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aR(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EW;
        if (this.cIN == null || (EW = this.cIN.EW()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EW.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Fc().toString());
            } else if (next.getType() == 17) {
                String str = next.Fg().atx.asY;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(i.C0057i.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(i.C0057i.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(i.C0057i.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aqb() {
        return this.cIO;
    }

    public void jJ(int i) {
        this.cIO = i;
    }

    public ac aqc() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EW;
        if (this.cIN != null && (EW = this.cIN.EW()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = EW.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ac acVar = new ac();
                    acVar.width = next.Fb().getWidth();
                    acVar.height = next.Fb().getHeight();
                    acVar.VY = next.Fb().Fk();
                    acVar.aau = 17;
                    return acVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<ac> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EW;
        if (this.cIN == null || (EW = this.cIN.EW()) == null) {
            return null;
        }
        ArrayList<ac> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EW.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ac acVar = new ac();
                acVar.width = next.Fb().getWidth();
                acVar.height = next.Fb().getHeight();
                acVar.VY = next.Fb().Fk();
                acVar.aau = 17;
                arrayList.add(acVar);
            } else if (next.Fg() != null) {
                ac acVar2 = new ac();
                acVar2.width = next.Fg().atx.atb;
                acVar2.height = next.Fg().atx.atc;
                acVar2.aav = next.Fg();
                acVar2.aau = 20;
                arrayList.add(acVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cIO) {
                break;
            }
            arrayList.addAll(this.cIM.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ac acVar3 = new ac();
            acVar3.VY = this.bimg_url;
            acVar3.width = 105;
            acVar3.width = 105;
            acVar3.aau = 19;
            arrayList.add(acVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ac acVar4 = new ac();
        acVar4.VY = this.author.getPortrait();
        acVar4.aau = 12;
        arrayList.add(acVar4);
        if (this.cIM != null) {
            Iterator<i> it2 = this.cIM.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cIF;
    }

    public boolean aqd() {
        return this.cIK;
    }

    public void fy(boolean z) {
        this.cIK = z;
    }
}
