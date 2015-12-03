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
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.n;
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
public class o implements u, aj {
    private String authorId;
    private String bimg_url;
    private SmallTailInfo cId;
    private String dzF;
    private ArrayList<o> dzH;
    private ArrayList<o> dzK;
    private int dzM;
    private com.baidu.tbadk.data.a dzP;
    private com.baidu.tbadk.data.d dzQ;
    private g dzS;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId dzy = BdUniqueId.gen();
    public static final BdUniqueId dzz = BdUniqueId.gen();
    public static final BdUniqueId dzA = BdUniqueId.gen();
    public static final BdUniqueId dzB = BdUniqueId.gen();
    public static final BdUniqueId dzC = BdUniqueId.gen();
    private int dzD = 0;
    private boolean dzI = false;
    private com.baidu.tbadk.widget.richText.a dzL = null;
    private boolean dzR = false;
    private String id = null;
    private String title = null;
    private int dzE = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<h> cfS = new ArrayList<>();
    private ArrayList<h> cgF = new ArrayList<>();
    private int dzG = 0;
    private int dzJ = 0;
    private int WF = 0;
    private PraiseData praise = new PraiseData();
    private r dzN = new r();
    private c dzO = new c();

    public o() {
        this.dzH = null;
        this.dzK = null;
        this.dzH = new ArrayList<>();
        this.dzK = new ArrayList<>();
    }

    public c aCY() {
        return this.dzO;
    }

    public ArrayList<o> aCZ() {
        return this.dzH;
    }

    public void aDa() {
        this.dzG++;
    }

    public void aDb() {
        this.dzG--;
    }

    public void mv(int i) {
        this.dzG = i;
    }

    public ArrayList<o> aDc() {
        return this.dzK;
    }

    public boolean isGiftPost() {
        return this.dzR;
    }

    public void setIsGiftPost(boolean z) {
        this.dzR = z;
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

    public int aDd() {
        return this.dzE;
    }

    public void mw(int i) {
        this.dzE = i;
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

    public com.baidu.tbadk.widget.richText.a aDe() {
        return this.dzL;
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar) {
        this.dzL = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aDf() {
        return this.dzP;
    }

    public SmallTailInfo amT() {
        return this.cId;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.cId = smallTailInfo;
    }

    public com.baidu.tbadk.data.d aDg() {
        return this.dzQ;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        v vVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cE;
        if (this.dzL != null && this.dzL.FL() != null) {
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new p(this, it.next(), bdUniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.d.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(n.d.small_icon_height));
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
            if (z && (cE = as.cE(n.e.icon_floorhost)) != null) {
                int width = (cE.getWidth() * dimensionPixelSize) / cE.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> FL = this.dzL.FL();
            if (FL != null && FL.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = FL.get(0);
                if (cVar2.FR() != null) {
                    cVar2.eV(sb.length());
                    cVar2.FR().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= FL.size()) {
                        vVar = null;
                        break;
                    } else if (FL.get(i4) == null || FL.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        v FS = FL.get(i4).FS();
                        FL.remove(i4);
                        vVar = FS;
                        break;
                    }
                }
                if (vVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(vVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.eV(sb.length());
                cVar.append(spannableString);
                FL.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap ng;
        if (aVar == null || (ng = aVar.ng()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ng);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(n.d.ds36), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(n.d.ds36));
        return bitmapDrawable;
    }

    public int aDh() {
        return this.dzG;
    }

    public int aDi() {
        return this.dzJ;
    }

    public void aP(Context context) {
        int type;
        int i;
        int i2;
        if (this.cfS != null) {
            int i3 = -1;
            int size = this.cgF.size();
            if (size > 0) {
                try {
                    i3 = this.cgF.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.cfS.size()) {
                h hVar = this.cfS.get(i4);
                if (h.aK(i5, hVar.getType())) {
                    this.cgF.get(size - 1).b(hVar.aO(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (hVar.getType() == 3 || hVar.getType() == 2 || hVar.getType() == 11) {
                        this.cgF.add(hVar);
                        type = hVar.getType();
                    } else {
                        h hVar2 = new h();
                        hVar2.setType(0);
                        hVar2.b(hVar.aO(context));
                        this.cgF.add(hVar2);
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
            if (this.dzL != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.dzL.toString());
                clipboardManager.getText();
                return;
            }
            if (this.cgF == null || this.cgF.size() == 0) {
                aP(context);
            }
            ArrayList<h> arrayList = this.cgF;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.getType() == 0) {
                        if (next.aCL() != null) {
                            sb.append((CharSequence) next.aCL());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(n.i.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(n.i.voice_str));
                    } else if (next.getType() == 2) {
                        String fc = TbFaceManager.CW().fc(next.getText());
                        if (fc != null) {
                            sb.append("[");
                            sb.append(fc);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ax.isEmpty(next.aCK())) {
                        sb.append("[").append(next.aCK()).append("]");
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
                this.dzE = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.dzR = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.dzL = TbRichTextView.b(context, subPostList.content, z);
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
                this.dzE = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.dzF = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.dzG = post.sub_post_number.intValue();
                this.dzJ = post.add_post_number.intValue();
                this.dzS = new g(post.tpoint_post);
                this.dzL = TbRichTextView.b(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            o oVar = new o();
                            oVar.dzR = subPostList.is_giftpost.intValue() == 1;
                            oVar.setUserMap(this.userMap);
                            oVar.a(subPostList, context);
                            this.dzH.add(oVar);
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
                            this.dzK.add(oVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.dzO.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.dzK.size() >= 5) {
                    this.dzM = 5;
                } else {
                    this.dzM = this.dzK.size();
                }
                if (post.tail_info != null) {
                    this.dzP = new com.baidu.tbadk.data.a();
                    this.dzP.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.dzQ = new com.baidu.tbadk.data.d();
                    this.dzQ.a(post.lbs_info);
                }
                this.WF = post.storecount.intValue();
                this.dzN.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.cId = new SmallTailInfo();
                    this.cId.id = post.signature.signature_id.intValue();
                    this.cId.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cId.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cId.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.cId.updateShowInfo();
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
                textPaint.setColor(as.getColor(n.c.cp_link_tip_c));
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
        ArrayList<com.baidu.tbadk.widget.richText.c> FL;
        if (this.dzL == null || (FL = this.dzL.FL()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = FL.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.FR().toString());
            } else if (next.getType() == 17) {
                String str = next.FV().auv.atV;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(n.i.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(n.i.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(n.i.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aDj() {
        return this.dzM;
    }

    public void mx(int i) {
        this.dzM = i;
    }

    public ai aDk() {
        ArrayList<com.baidu.tbadk.widget.richText.c> FL;
        if (this.dzL != null && (FL = this.dzL.FL()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = FL.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ai aiVar = new ai();
                    aiVar.width = next.FQ().getWidth();
                    aiVar.height = next.FQ().getHeight();
                    aiVar.WN = next.FQ().Gb();
                    aiVar.abp = 17;
                    return aiVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> FL;
        if (this.dzL == null || (FL = this.dzL.FL()) == null) {
            return null;
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = FL.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ai aiVar = new ai();
                aiVar.width = next.FQ().getWidth();
                aiVar.height = next.FQ().getHeight();
                aiVar.WN = next.FQ().Gb();
                aiVar.abp = 17;
                arrayList.add(aiVar);
            } else if (next.FV() != null) {
                ai aiVar2 = new ai();
                aiVar2.width = next.FV().auv.atY;
                aiVar2.height = next.FV().auv.atZ;
                aiVar2.abq = next.FV();
                aiVar2.abp = 20;
                arrayList.add(aiVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dzM) {
                break;
            }
            arrayList.addAll(this.dzK.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ai aiVar3 = new ai();
            aiVar3.WN = this.bimg_url;
            aiVar3.width = 105;
            aiVar3.width = 105;
            aiVar3.abp = 19;
            arrayList.add(aiVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ai aiVar4 = new ai();
        aiVar4.WN = this.author.getPortrait();
        aiVar4.abp = 12;
        arrayList.add(aiVar4);
        if (this.dzK != null) {
            Iterator<o> it2 = this.dzK.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.dzD == 2) {
            return dzz;
        }
        if (this.dzD == 1) {
            return dzA;
        }
        if (this.dzD == 36) {
            return dzC;
        }
        if (this.dzS != null && this.dzS.dzp) {
            return dzB;
        }
        return dzy;
    }

    public boolean aDl() {
        return this.dzI;
    }

    public void hk(boolean z) {
        this.dzI = z;
    }

    public void setPostType(int i) {
        this.dzD = i;
    }

    public r aDm() {
        return this.dzN;
    }

    public void a(r rVar) {
        this.dzN = rVar;
    }

    public g aDn() {
        return this.dzS;
    }
}
