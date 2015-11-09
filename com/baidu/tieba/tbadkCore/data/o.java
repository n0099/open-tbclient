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
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class o implements u, ae {
    public static final BdUniqueId daM = BdUniqueId.gen();
    public static final BdUniqueId daN = BdUniqueId.gen();
    public static final BdUniqueId daO = BdUniqueId.gen();
    public static final BdUniqueId daP = BdUniqueId.gen();
    public static final BdUniqueId daQ = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private SmallTailInfo coR;
    private String daT;
    private ArrayList<o> daV;
    private ArrayList<o> daY;
    private int dba;
    private com.baidu.tbadk.data.a dbc;
    private com.baidu.tbadk.data.d dbd;
    private g dbf;
    private HashMap<String, MetaData> userMap;
    private int daR = 0;
    private boolean daW = false;
    private com.baidu.tbadk.widget.richText.a daZ = null;
    private boolean dbe = false;
    private String id = null;
    private String title = null;
    private int daS = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<h> bPF = new ArrayList<>();
    private ArrayList<h> bQs = new ArrayList<>();
    private int daU = 0;
    private int daX = 0;
    private int VY = 0;
    private PraiseData praise = new PraiseData();
    private c dbb = new c();

    public o() {
        this.daV = null;
        this.daY = null;
        this.daV = new ArrayList<>();
        this.daY = new ArrayList<>();
    }

    public c axo() {
        return this.dbb;
    }

    public ArrayList<o> axp() {
        return this.daV;
    }

    public void axq() {
        this.daU++;
    }

    public void axr() {
        this.daU--;
    }

    public void lj(int i) {
        this.daU = i;
    }

    public ArrayList<o> axs() {
        return this.daY;
    }

    public boolean isGiftPost() {
        return this.dbe;
    }

    public void setIsGiftPost(boolean z) {
        this.dbe = z;
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

    public int axt() {
        return this.daS;
    }

    public void lk(int i) {
        this.daS = i;
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

    public com.baidu.tbadk.widget.richText.a axu() {
        return this.daZ;
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar) {
        this.daZ = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a axv() {
        return this.dbc;
    }

    public SmallTailInfo aiq() {
        return this.coR;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.coR = smallTailInfo;
    }

    public com.baidu.tbadk.data.d axw() {
        return this.dbd;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        v vVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cw;
        if (this.daZ != null && this.daZ.EI() != null) {
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
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new p(this, it.next(), bdUniqueId), 0, 1);
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
            if (z && (cw = an.cw(i.e.icon_floorhost)) != null) {
                int width = (cw.getWidth() * dimensionPixelSize) / cw.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.g gVar = new com.baidu.tbadk.widget.g(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(gVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(gVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> EI = this.daZ.EI();
            if (EI != null && EI.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = EI.get(0);
                if (cVar2.EO() != null) {
                    cVar2.eI(sb.length());
                    cVar2.EO().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= EI.size()) {
                        vVar = null;
                        break;
                    } else if (EI.get(i4) == null || EI.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        v EP = EI.get(i4).EP();
                        EI.remove(i4);
                        vVar = EP;
                        break;
                    }
                }
                if (vVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(vVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.eI(sb.length());
                cVar.append(spannableString);
                EI.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap nb;
        if (aVar == null || (nb = aVar.nb()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(i.d.small_icon_height));
        return bitmapDrawable;
    }

    public int axx() {
        return this.daU;
    }

    public int axy() {
        return this.daX;
    }

    public void aQ(Context context) {
        int type;
        int i;
        int i2;
        if (this.bPF != null) {
            int i3 = -1;
            int size = this.bQs.size();
            if (size > 0) {
                try {
                    i3 = this.bQs.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bPF.size()) {
                h hVar = this.bPF.get(i4);
                if (h.aH(i5, hVar.getType())) {
                    this.bQs.get(size - 1).b(hVar.aP(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (hVar.getType() == 3 || hVar.getType() == 2 || hVar.getType() == 11) {
                        this.bQs.add(hVar);
                        type = hVar.getType();
                    } else {
                        h hVar2 = new h();
                        hVar2.setType(0);
                        hVar2.b(hVar.aP(context));
                        this.bQs.add(hVar2);
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

    public void aR(Context context) {
        try {
            if (this.daZ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.daZ.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bQs == null || this.bQs.size() == 0) {
                aQ(context);
            }
            ArrayList<h> arrayList = this.bQs;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.getType() == 0) {
                        if (next.awZ() != null) {
                            sb.append((CharSequence) next.awZ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(i.h.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(i.h.voice_str));
                    } else if (next.getType() == 2) {
                        String eO = TbFaceManager.BU().eO(next.getText());
                        if (eO != null) {
                            sb.append("[");
                            sb.append(eO);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !as.isEmpty(next.awY())) {
                        sb.append("[").append(next.awY()).append("]");
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
                this.daS = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.dbe = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.daZ = TbRichTextView.b(context, subPostList.content, z);
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
                this.daS = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.daT = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.daU = post.sub_post_number.intValue();
                this.daX = post.add_post_number.intValue();
                this.dbf = new g(post.tpoint_post);
                this.daZ = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            o oVar = new o();
                            oVar.dbe = subPostList.is_giftpost.intValue() == 1;
                            oVar.setUserMap(this.userMap);
                            oVar.a(subPostList, context);
                            this.daV.add(oVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            o oVar2 = new o();
                            oVar2.setUserMap(this.userMap);
                            oVar2.a(subPostList2, context);
                            this.daY.add(oVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.dbb.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.daY.size() >= 5) {
                    this.dba = 5;
                } else {
                    this.dba = this.daY.size();
                }
                if (post.tail_info != null) {
                    this.dbc = new com.baidu.tbadk.data.a();
                    this.dbc.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.dbd = new com.baidu.tbadk.data.d();
                    this.dbd.a(post.lbs_info);
                }
                this.VY = post.storecount.intValue();
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.coR = new SmallTailInfo();
                    this.coR.id = post.signature.signature_id.intValue();
                    this.coR.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.coR.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.coR.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.coR.updateShowInfo();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
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
                textPaint.setColor(an.getColor(i.c.cp_link_tip_c));
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

    public String aS(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EI;
        if (this.daZ == null || (EI = this.daZ.EI()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EI.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.EO().toString());
            } else if (next.getType() == 17) {
                String str = next.ES().ast.arU;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(i.h.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(i.h.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(i.h.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int axz() {
        return this.dba;
    }

    public void ll(int i) {
        this.dba = i;
    }

    public ad axA() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EI;
        if (this.daZ != null && (EI = this.daZ.EI()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = EI.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ad adVar = new ad();
                    adVar.width = next.EN().getWidth();
                    adVar.height = next.EN().getHeight();
                    adVar.Wd = next.EN().EY();
                    adVar.aaD = 17;
                    return adVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> EI;
        if (this.daZ == null || (EI = this.daZ.EI()) == null) {
            return null;
        }
        ArrayList<ad> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = EI.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ad adVar = new ad();
                adVar.width = next.EN().getWidth();
                adVar.height = next.EN().getHeight();
                adVar.Wd = next.EN().EY();
                adVar.aaD = 17;
                arrayList.add(adVar);
            } else if (next.ES() != null) {
                ad adVar2 = new ad();
                adVar2.width = next.ES().ast.arX;
                adVar2.height = next.ES().ast.arY;
                adVar2.aaE = next.ES();
                adVar2.aaD = 20;
                arrayList.add(adVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dba) {
                break;
            }
            arrayList.addAll(this.daY.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ad adVar3 = new ad();
            adVar3.Wd = this.bimg_url;
            adVar3.width = 105;
            adVar3.width = 105;
            adVar3.aaD = 19;
            arrayList.add(adVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ad adVar4 = new ad();
        adVar4.Wd = this.author.getPortrait();
        adVar4.aaD = 12;
        arrayList.add(adVar4);
        if (this.daY != null) {
            Iterator<o> it2 = this.daY.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.daR == 2) {
            return daN;
        }
        if (this.daR == 1) {
            return daO;
        }
        if (this.daR == 36) {
            return daQ;
        }
        if (this.dbf != null && this.dbf.daD) {
            return daP;
        }
        return daM;
    }

    public boolean axB() {
        return this.daW;
    }

    public void gw(boolean z) {
        this.daW = z;
    }

    public void setPostType(int i) {
        this.daR = i;
    }

    public g axC() {
        return this.dbf;
    }
}
