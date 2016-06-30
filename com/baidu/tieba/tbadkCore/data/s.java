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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.u;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class s implements v, al {
    private ba Rf;
    private SkinInfo Ri;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String dLC;
    private SmallTailInfo dYc;
    public DealInfoData dealInfoData;
    private ArrayList<s> eXS;
    private ArrayList<s> eXV;
    private int eXW;
    private com.baidu.tbadk.data.b eYa;
    private com.baidu.tbadk.data.g eYb;
    private i eYd;
    private com.baidu.tbadk.widget.richText.o eYe;
    private String eYf;
    private String eYg;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId eXE = BdUniqueId.gen();
    public static final BdUniqueId eXF = BdUniqueId.gen();
    public static final BdUniqueId Rj = BdUniqueId.gen();
    public static final BdUniqueId eXG = BdUniqueId.gen();
    public static final BdUniqueId eXH = BdUniqueId.gen();
    public static final BdUniqueId Qh = BdUniqueId.gen();
    public static final BdUniqueId eXI = BdUniqueId.gen();
    public static final BdUniqueId eXJ = BdUniqueId.gen();
    public static final BdUniqueId eXK = BdUniqueId.gen();
    public static final BdUniqueId eXL = BdUniqueId.gen();
    public static final BdUniqueId eXM = BdUniqueId.gen();
    public static final BdUniqueId dMj = BdUniqueId.gen();
    public static final BdUniqueId eXN = BdUniqueId.gen();
    public static boolean eXO = false;
    private int eXP = 0;
    private boolean eXT = false;
    private com.baidu.tbadk.widget.richText.a dhI = null;
    private boolean eXZ = false;
    private boolean eYc = false;
    public boolean eYh = false;
    private String id = null;
    private String title = null;
    private int eXQ = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> dfu = new ArrayList<>();
    private ArrayList<l> dgk = new ArrayList<>();
    private int eXR = 0;
    private int eXU = 0;
    private int QT = 0;
    private PraiseData praise = new PraiseData();
    private ag eXX = new ag();
    private c eXY = new c();
    private ArrayList<com.baidu.tbadk.data.b> Rg = new ArrayList<>();

    public s() {
        this.eXS = null;
        this.eXV = null;
        this.eXS = new ArrayList<>();
        this.eXV = new ArrayList<>();
    }

    public c bch() {
        return this.eXY;
    }

    public ArrayList<s> bci() {
        return this.eXS;
    }

    public void bcj() {
        this.eXR++;
    }

    public void bck() {
        this.eXR--;
    }

    public void qC(int i) {
        this.eXR = i;
    }

    public ArrayList<s> bcl() {
        return this.eXV;
    }

    public boolean isGiftPost() {
        return this.eYc;
    }

    public void setIsGiftPost(boolean z) {
        this.eYc = z;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aDB() {
        return this.dLC;
    }

    public int bcm() {
        return this.eXQ;
    }

    public void qD(int i) {
        this.eXQ = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.ba.y(j);
    }

    public String bcn() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public PraiseData getPraise() {
        return this.praise;
    }

    public void setPraise(PraiseData praiseData) {
        this.praise = praiseData;
    }

    public com.baidu.tbadk.widget.richText.a auL() {
        return this.dhI;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.dhI = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.b bco() {
        return this.eYa;
    }

    public SmallTailInfo aIV() {
        return this.dYc;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.dYc = smallTailInfo;
    }

    public com.baidu.tbadk.data.g bcp() {
        return this.eYb;
    }

    public SkinInfo qZ() {
        return this.Ri;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        z zVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cA;
        if (tbPageContext != null && this.dhI != null && this.dhI.GF() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new t(this, it.next(), uniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(u.e.ds32), TbadkCoreApplication.m9getInst().getApp().getResources().getDimensionPixelSize(u.e.ds32));
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
            a aVar = new a(tbPageContext.getPageActivity(), str, str2);
            if (z && (cA = av.cA(u.f.icon_floorhost)) != null) {
                int width = (cA.getWidth() * dimensionPixelSize) / cA.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
                bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> GF = this.dhI.GF();
            if (GF != null && GF.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = GF.get(0);
                if (cVar2.GL() != null) {
                    cVar2.fg(sb.length());
                    cVar2.GL().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= GF.size()) {
                        zVar = null;
                        break;
                    } else if (GF.get(i4) == null || GF.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        z GM = GF.get(i4).GM();
                        GF.remove(i4);
                        zVar = GM;
                        break;
                    }
                }
                if (zVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(zVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fg(sb.length());
                cVar.append(spannableString);
                GF.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap jb;
        if (aVar == null || (jb = aVar.jb()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jb);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.e.ds36), TbadkCoreApplication.m9getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.e.ds36));
        return bitmapDrawable;
    }

    public int bcq() {
        return this.eXR;
    }

    public int bcr() {
        return this.eXU;
    }

    public void aU(Context context) {
        int type;
        int i;
        int i2;
        if (this.dfu != null) {
            int i3 = -1;
            int size = this.dgk.size();
            if (size > 0) {
                try {
                    i3 = this.dgk.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.dfu.size()) {
                l lVar = this.dfu.get(i4);
                if (l.bi(i5, lVar.getType())) {
                    this.dgk.get(size - 1).a(lVar.aT(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.dgk.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.a(lVar.aT(context));
                        this.dgk.add(lVar2);
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

    public void aV(Context context) {
        try {
            if (this.dhI != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dhI.toString());
                clipboardManager.getText();
                return;
            }
            if (this.dgk == null || this.dgk.size() == 0) {
                aU(context);
            }
            ArrayList<l> arrayList = this.dgk;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.bbV() != null) {
                            sb.append((CharSequence) next.bbV());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(u.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(u.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fq = TbFaceManager.CP().fq(next.getText());
                        if (fq != null) {
                            sb.append("[");
                            sb.append(fq);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.ba.isEmpty(next.bbU())) {
                        sb.append("[").append(next.bbU()).append("]");
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
                this.eXQ = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.ba.y(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.eYc = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dhI = TbRichTextView.b(context, subPostList.content, z);
                if (this.dhI != null) {
                    this.dhI.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
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
                this.eXQ = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.ba.y(this.time);
                this.dLC = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.eYf = String.valueOf(this.author.getUserName()) + context.getResources().getString(u.j.whose_head_image);
                    this.eYg = String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.eXZ = post.is_ntitle.intValue() == 1;
                this.eXR = post.sub_post_number.intValue();
                this.eXU = post.add_post_number.intValue();
                this.eYd = new i(post.tpoint_post);
                this.dhI = TbRichTextView.b(context, post.content, true);
                if (this.dhI != null) {
                    this.dhI.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.dhI.ff(this.eXQ);
                    if (this.author != null) {
                        this.dhI.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            s sVar = new s();
                            sVar.eYc = subPostList.is_giftpost.intValue() == 1;
                            sVar.setUserMap(this.userMap);
                            sVar.a(subPostList, context);
                            this.eXS.add(sVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            s sVar2 = new s();
                            sVar2.setUserMap(this.userMap);
                            sVar2.a(subPostList2, context);
                            this.eXV.add(sVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.eXY.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.eXV.size() >= 5) {
                    this.eXW = 5;
                } else {
                    this.eXW = this.eXV.size();
                }
                if (post.tail_info != null) {
                    this.eYa = new com.baidu.tbadk.data.b();
                    this.eYa.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.eYb = new com.baidu.tbadk.data.g();
                    this.eYb.a(post.lbs_info);
                }
                this.QT = post.storecount.intValue();
                this.eXX.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.dYc = new SmallTailInfo();
                    this.dYc.id = post.signature.signature_id.intValue();
                    this.dYc.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.dYc.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.dYc.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.dYc.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(post.ext_tails.get(i2));
                        this.Rg.add(bVar);
                    }
                }
                if (post.high_together != null) {
                    this.Rf = new ba();
                    this.Rf.a(post.high_together);
                }
                this.Ri = post.skin_info;
                if (post.pb_deal_info != null) {
                    this.dealInfoData = new DealInfoData();
                    this.dealInfoData.parserProtobuf(post.pb_deal_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> eYn;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.eYn = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.eYn != null) {
                textPaint.setColor(av.getColor(u.d.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.eYn != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eYn.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aW(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GF;
        if (this.dhI == null || (GF = this.dhI.GF()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.GL().toString());
            } else if (next.getType() == 17) {
                String str = next.GP().auo.atP;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(u.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(u.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(u.j.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(u.j.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int bcs() {
        return this.eXW;
    }

    public void qE(int i) {
        this.eXW = i;
    }

    public ak bct() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GF;
        if (this.dhI != null && (GF = this.dhI.GF()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = GF.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ak akVar = new ak();
                    akVar.width = next.GK().getWidth();
                    akVar.height = next.GK().getHeight();
                    akVar.imgUrl = next.GK().GX();
                    akVar.Xu = 17;
                    return akVar;
                } else if (next.getType() == 1536) {
                    if (next.GT() == null || TextUtils.isEmpty(next.GT().url)) {
                        return null;
                    }
                    ak akVar2 = new ak();
                    akVar2.imgUrl = next.GT().url;
                    akVar2.Xu = 17;
                    return akVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<ak> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GF;
        if (this.dhI == null || (GF = this.dhI.GF()) == null) {
            return null;
        }
        ArrayList<ak> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ak akVar = new ak();
                akVar.width = next.GK().getWidth();
                akVar.height = next.GK().getHeight();
                akVar.imgUrl = next.GK().GX();
                akVar.Xu = 17;
                arrayList.add(akVar);
            } else if (next.GP() != null) {
                ak akVar2 = new ak();
                akVar2.width = next.GP().auo.atS;
                akVar2.height = next.GP().auo.atT;
                akVar2.Xv = next.GP();
                akVar2.Xu = 20;
                arrayList.add(akVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eXW) {
                break;
            }
            arrayList.addAll(this.eXV.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ak akVar3 = new ak();
            akVar3.imgUrl = this.bimg_url;
            akVar3.width = 105;
            akVar3.width = 105;
            akVar3.Xu = 19;
            arrayList.add(akVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ak akVar4 = new ak();
        akVar4.imgUrl = this.author.getPortrait();
        akVar4.Xu = 12;
        arrayList.add(akVar4);
        if (this.eXV != null) {
            Iterator<s> it2 = this.eXV.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.eXP == 2) {
            return eXF;
        }
        if (this.eXP == 1) {
            return Rj;
        }
        if (this.eXP == 36) {
            return eXH;
        }
        if (this.eXP == 40) {
            return Qh;
        }
        if (this.eXP == 41) {
            return eXL;
        }
        if (eXO && this.eYd != null && this.eYd.eXl) {
            int bbO = this.eYd.bbO();
            if (bbO == 2) {
                return eXI;
            }
            if (bbO == 1) {
                return eXJ;
            }
            if (bbO == 3) {
                return eXK;
            }
            return eXG;
        } else if (this.Rf != null && !TextUtils.isEmpty(this.Rf.getActivityName())) {
            return eXN;
        } else {
            return eXE;
        }
    }

    public boolean bcu() {
        return this.eXT;
    }

    public void kk(boolean z) {
        this.eXT = z;
    }

    public void setPostType(int i) {
        this.eXP = i;
    }

    public ag bcv() {
        return this.eXX;
    }

    public void a(ag agVar) {
        this.eXX = agVar;
    }

    public i bcw() {
        return this.eYd;
    }

    public com.baidu.tbadk.widget.richText.o GO() {
        if (this.eYe != null) {
            return this.eYe;
        }
        if (this.dhI != null && y.s(this.dhI.GF()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.dhI.GF().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.eYe = next.GO();
                    return this.eYe;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.b> bcx() {
        return this.Rg;
    }

    public String bcy() {
        return this.eYf;
    }

    public String bcz() {
        return this.eYg;
    }
}
