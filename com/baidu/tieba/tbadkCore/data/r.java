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
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
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
public class r implements u, ai {
    private String authorId;
    private String bimg_url;
    private com.baidu.tbadk.widget.richText.m cLa;
    private SmallTailInfo cUN;
    private String dXh;
    private ArrayList<r> dXj;
    private ArrayList<r> dXm;
    private int dXn;
    private com.baidu.tbadk.data.a dXr;
    private com.baidu.tbadk.data.d dXs;
    private h dXu;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId dWX = BdUniqueId.gen();
    public static final BdUniqueId dWY = BdUniqueId.gen();
    public static final BdUniqueId dWZ = BdUniqueId.gen();
    public static final BdUniqueId dXa = BdUniqueId.gen();
    public static final BdUniqueId dXb = BdUniqueId.gen();
    public static final BdUniqueId WH = BdUniqueId.gen();
    public static final BdUniqueId dXc = BdUniqueId.gen();
    public static final BdUniqueId dXd = BdUniqueId.gen();
    public static final BdUniqueId dXe = BdUniqueId.gen();
    private int dXf = 0;
    private boolean dXk = false;
    private com.baidu.tbadk.widget.richText.a cqL = null;
    private boolean dXq = false;
    private boolean dXt = false;
    private String id = null;
    private String title = null;
    private int dXg = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<k> cov = new ArrayList<>();
    private ArrayList<k> cpl = new ArrayList<>();
    private int dXi = 0;
    private int dXl = 0;
    private int Xn = 0;
    private PraiseData praise = new PraiseData();
    private v dXo = new v();
    private c dXp = new c();

    public r() {
        this.dXj = null;
        this.dXm = null;
        this.dXj = new ArrayList<>();
        this.dXm = new ArrayList<>();
    }

    public c aMr() {
        return this.dXp;
    }

    public ArrayList<r> aMs() {
        return this.dXj;
    }

    public void aMt() {
        this.dXi++;
    }

    public void aMu() {
        this.dXi--;
    }

    public void oi(int i) {
        this.dXi = i;
    }

    public ArrayList<r> aMv() {
        return this.dXm;
    }

    public boolean isGiftPost() {
        return this.dXt;
    }

    public void setIsGiftPost(boolean z) {
        this.dXt = z;
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

    public int aMw() {
        return this.dXg;
    }

    public void oj(int i) {
        this.dXg = i;
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

    public com.baidu.tbadk.widget.richText.a aiT() {
        return this.cqL;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.cqL = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aMx() {
        return this.dXr;
    }

    public SmallTailInfo asK() {
        return this.cUN;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.cUN = smallTailInfo;
    }

    public com.baidu.tbadk.data.d aMy() {
        return this.dXs;
    }

    public void a(BdUniqueId bdUniqueId, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        com.baidu.tbadk.widget.richText.v vVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cO;
        if (this.cqL != null && this.cqL.GS() != null) {
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new s(this, it.next(), bdUniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_height));
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
            if (z && (cO = ar.cO(t.f.icon_floorhost)) != null) {
                int width = (cO.getWidth() * dimensionPixelSize) / cO.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> GS = this.cqL.GS();
            if (GS != null && GS.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = GS.get(0);
                if (cVar2.GY() != null) {
                    cVar2.fk(sb.length());
                    cVar2.GY().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= GS.size()) {
                        vVar = null;
                        break;
                    } else if (GS.get(i4) == null || GS.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        com.baidu.tbadk.widget.richText.v GZ = GS.get(i4).GZ();
                        GS.remove(i4);
                        vVar = GZ;
                        break;
                    }
                }
                if (vVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(vVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fk(sb.length());
                cVar.append(spannableString);
                GS.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap mS;
        if (aVar == null || (mS = aVar.mS()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mS);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36));
        return bitmapDrawable;
    }

    public int aMz() {
        return this.dXi;
    }

    public int aMA() {
        return this.dXl;
    }

    public void aS(Context context) {
        int type;
        int i;
        int i2;
        if (this.cov != null) {
            int i3 = -1;
            int size = this.cpl.size();
            if (size > 0) {
                try {
                    i3 = this.cpl.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.cov.size()) {
                k kVar = this.cov.get(i4);
                if (k.bc(i5, kVar.getType())) {
                    this.cpl.get(size - 1).b(kVar.aR(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.cpl.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.aR(context));
                        this.cpl.add(kVar2);
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

    public void aT(Context context) {
        try {
            if (this.cqL != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cqL.toString());
                clipboardManager.getText();
                return;
            }
            if (this.cpl == null || this.cpl.size() == 0) {
                aS(context);
            }
            ArrayList<k> arrayList = this.cpl;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.aMe() != null) {
                            sb.append((CharSequence) next.aMe());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(t.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(t.j.voice_str));
                    } else if (next.getType() == 2) {
                        String ff = TbFaceManager.Ec().ff(next.getText());
                        if (ff != null) {
                            sb.append("[");
                            sb.append(ff);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aw.isEmpty(next.aMd())) {
                        sb.append("[").append(next.aMd()).append("]");
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
                this.dXg = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                this.dXt = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cqL = TbRichTextView.b(context, subPostList.content, z);
                if (this.cqL != null) {
                    this.cqL.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
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
                this.dXg = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.dXh = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.dXq = post.is_ntitle.intValue() == 1;
                this.dXi = post.sub_post_number.intValue();
                this.dXl = post.add_post_number.intValue();
                this.dXu = new h(post.tpoint_post);
                this.cqL = TbRichTextView.b(context, post.content, true);
                if (this.cqL != null) {
                    this.cqL.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            r rVar = new r();
                            rVar.dXt = subPostList.is_giftpost.intValue() == 1;
                            rVar.setUserMap(this.userMap);
                            rVar.a(subPostList, context);
                            this.dXj.add(rVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            r rVar2 = new r();
                            rVar2.setUserMap(this.userMap);
                            rVar2.a(subPostList2, context);
                            this.dXm.add(rVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.dXp.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.dXm.size() >= 5) {
                    this.dXn = 5;
                } else {
                    this.dXn = this.dXm.size();
                }
                if (post.tail_info != null) {
                    this.dXr = new com.baidu.tbadk.data.a();
                    this.dXr.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.dXs = new com.baidu.tbadk.data.d();
                    this.dXs.a(post.lbs_info);
                }
                this.Xn = post.storecount.intValue();
                this.dXo.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.cUN = new SmallTailInfo();
                    this.cUN.id = post.signature.signature_id.intValue();
                    this.cUN.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.cUN.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.cUN.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.cUN.updateShowInfo();
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
                textPaint.setColor(ar.getColor(t.d.cp_link_tip_c));
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

    public String aU(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GS;
        if (this.cqL == null || (GS = this.cqL.GS()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GS.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.GY().toString());
            } else if (next.getType() == 17) {
                String str = next.Hc().awQ.awr;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(t.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(t.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(t.j.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aMB() {
        return this.dXn;
    }

    public void ok(int i) {
        this.dXn = i;
    }

    public ah aMC() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GS;
        if (this.cqL != null && (GS = this.cqL.GS()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = GS.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ah ahVar = new ah();
                    ahVar.width = next.GX().getWidth();
                    ahVar.height = next.GX().getHeight();
                    ahVar.imgUrl = next.GX().Hi();
                    ahVar.acq = 17;
                    return ahVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<ah> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> GS;
        if (this.cqL == null || (GS = this.cqL.GS()) == null) {
            return null;
        }
        ArrayList<ah> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = GS.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ah ahVar = new ah();
                ahVar.width = next.GX().getWidth();
                ahVar.height = next.GX().getHeight();
                ahVar.imgUrl = next.GX().Hi();
                ahVar.acq = 17;
                arrayList.add(ahVar);
            } else if (next.Hc() != null) {
                ah ahVar2 = new ah();
                ahVar2.width = next.Hc().awQ.awu;
                ahVar2.height = next.Hc().awQ.awv;
                ahVar2.acr = next.Hc();
                ahVar2.acq = 20;
                arrayList.add(ahVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dXn) {
                break;
            }
            arrayList.addAll(this.dXm.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ah ahVar3 = new ah();
            ahVar3.imgUrl = this.bimg_url;
            ahVar3.width = 105;
            ahVar3.width = 105;
            ahVar3.acq = 19;
            arrayList.add(ahVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ah ahVar4 = new ah();
        ahVar4.imgUrl = this.author.getPortrait();
        ahVar4.acq = 12;
        arrayList.add(ahVar4);
        if (this.dXm != null) {
            Iterator<r> it2 = this.dXm.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.dXf == 2) {
            return dWY;
        }
        if (this.dXf == 1) {
            return dWZ;
        }
        if (this.dXf == 36) {
            return dXb;
        }
        if (this.dXf == 40) {
            return WH;
        }
        if (this.dXf == 41) {
            return dXe;
        }
        if (this.dXu != null && this.dXu.dWF) {
            int aLZ = this.dXu.aLZ();
            if (aLZ == 2) {
                return dXc;
            }
            if (aLZ == 1) {
                return dXd;
            }
            return dXa;
        }
        return dWX;
    }

    public boolean aMD() {
        return this.dXk;
    }

    public void hU(boolean z) {
        this.dXk = z;
    }

    public void setPostType(int i) {
        this.dXf = i;
    }

    public v aME() {
        return this.dXo;
    }

    public void a(v vVar) {
        this.dXo = vVar;
    }

    public h aMF() {
        return this.dXu;
    }

    public com.baidu.tbadk.widget.richText.m Hb() {
        if (this.cLa != null) {
            return this.cLa;
        }
        if (this.cqL != null && x.o(this.cqL.GS()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.cqL.GS().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.cLa = next.Hb();
                    return this.cLa;
                }
            }
        }
        return null;
    }
}
