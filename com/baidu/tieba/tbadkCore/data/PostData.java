package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.n, ag {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eQZ;
    private SkinInfo eUV;
    private String eUY;
    private OriginalThreadInfo eVB;
    private Item eWt;
    private TbRichTextVoiceInfo fnv;
    private String lGu;
    public int locate;
    private SmallTailInfo mdt;
    private String nrC;
    private ArrayList<PostData> nrG;
    private com.baidu.tbadk.data.c nrN;
    private com.baidu.tbadk.data.g nrO;
    private i nrR;
    private bv nrS;
    public boolean nrU;
    private com.baidu.tbadk.widget.richText.i nrV;
    private String nrW;
    private String nrX;
    private TPointPost nrY;
    public int nsb;
    public boolean nse;
    public AlaLiveInfoCoreData nsh;
    private boolean nsl;
    public aq nsp;
    public List<PbContent> nss;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nrt = BdUniqueId.gen();
    public static final BdUniqueId nru = BdUniqueId.gen();
    public static final BdUniqueId eUW = BdUniqueId.gen();
    public static final BdUniqueId eTd = BdUniqueId.gen();
    public static final BdUniqueId eTj = BdUniqueId.gen();
    public static final BdUniqueId nrv = BdUniqueId.gen();
    public static final BdUniqueId nrw = BdUniqueId.gen();
    public static final BdUniqueId nrx = BdUniqueId.gen();
    public static final BdUniqueId nry = BdUniqueId.gen();
    public static final BdUniqueId nrz = BdUniqueId.gen();
    public static boolean nrA = false;
    private int nrB = 0;
    private boolean nrH = false;
    private ArrayList<PostData> nrI = null;
    private TbRichText nrJ = null;
    private boolean nrM = false;
    private boolean nrP = false;
    private boolean nrQ = false;
    public boolean nrT = false;
    public int eUv = 0;
    private boolean nrZ = false;
    public boolean jog = false;
    public boolean nsa = false;
    public boolean nsc = false;
    public boolean nsd = true;
    public boolean nsf = false;
    public boolean nsg = false;
    private boolean nsi = false;
    private int nsj = 0;
    private boolean nsk = true;
    public boolean nsm = false;
    public boolean nsn = false;
    public boolean nso = false;
    public boolean nsq = false;
    public boolean nsr = false;
    int nst = com.baidu.tbadk.a.d.bmQ();
    private b nsu = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nsp != null) {
                aq bwn = PostData.this.nsp.bwn();
                bwn.delete("obj_locate");
                bwn.an("obj_locate", 7);
                TiebaStatic.log(bwn);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eTY = new MetaData();
    private ArrayList<l> nrD = new ArrayList<>();
    private ArrayList<l> nrE = new ArrayList<>();
    private int nrF = 0;
    private int eUG = 0;
    private PraiseData eUj = new PraiseData();
    private az nrK = new az();
    private c nrL = new c();
    private ArrayList<com.baidu.tbadk.data.c> eUS = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nrG = null;
        this.nsb = 0;
        this.nrG = new ArrayList<>();
        this.nsb = 0;
    }

    public void yd(boolean z) {
        this.nsl = z;
    }

    public boolean dOW() {
        return this.nsl;
    }

    public ArrayList<PostData> dOX() {
        return this.nrI;
    }

    public void dOY() {
        this.nrI.clear();
        this.nrI = null;
        this.nrH = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nrI == null) {
                this.nrI = new ArrayList<>();
                if (x.getCount(this.nrG) > this.nst) {
                    this.nrI.addAll(x.subList(this.nrG, 0, this.nst));
                } else {
                    this.nrI.addAll(this.nrG);
                }
            }
            this.nrI.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nrG != null) {
            this.nrG.add(postData);
            dPc();
        }
    }

    public void To(String str) {
        if (this.nrI != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nrI.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nrI.remove(next);
                    return;
                }
            }
        }
    }

    public void ye(boolean z) {
        this.nsk = z;
    }

    public boolean dOZ() {
        return this.nsk;
    }

    public void yf(boolean z) {
        this.nrH = z;
    }

    public boolean dPa() {
        return this.nrH;
    }

    public ArrayList<PostData> dPb() {
        return this.nrG;
    }

    public void dPc() {
        this.nrF++;
    }

    public void dPd() {
        this.nrF--;
    }

    public void KQ(int i) {
        this.nrF = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dPe() {
        return this.floor_num;
    }

    public void KR(int i) {
        this.floor_num = i;
    }

    public boolean dPf() {
        return this.nrQ;
    }

    public void yg(boolean z) {
        this.nrQ = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData brr() {
        return this.eTY;
    }

    public void a(MetaData metaData) {
        this.eTY = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eUj = praiseData;
    }

    public TbRichText dPg() {
        return this.nrJ;
    }

    public void c(TbRichText tbRichText) {
        this.nrJ = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo duP() {
        return this.mdt;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.mdt = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dPh() {
        return this.nrO;
    }

    public SkinInfo brM() {
        return this.eUV;
    }

    public void yh(boolean z) {
        this.nsi = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nrJ != null && this.nrJ.bKX() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.eTY != null && this.eTY.getIs_bawu() == 1) {
                    if (this.nsl) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eTY.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eTY.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eTY.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eTY.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = brr().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mx().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nrJ.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.eTY.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eTY.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eTY != null) {
                spannableString = new SpannableString(sb2 + this.eTY.getName_show() + str + "：");
                String userName = this.eTY.getUserName();
                str2 = this.eTY.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eTY.getSealPrefix())) {
                Bitmap bitmap = ao.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eTY.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nsu), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eTY != null && this.eTY.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.eTY != null && this.eTY.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.eTY != null) {
                        int i4 = 0;
                        if (this.eTY.getName_show() != null) {
                            i4 = this.eTY.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bKX = this.nrJ.bKX();
            if (bKX != null && bKX.size() > 0) {
                TbRichTextData tbRichTextData2 = bKX.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bLe() != null) {
                    if (this.nsi) {
                        int indexOf = tbRichTextData2.bLe().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bLe().delete(0, indexOf + 1);
                        }
                        this.nsi = false;
                    }
                    tbRichTextData2.tL(sb.length());
                    tbRichTextData2.bLe().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bKX.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bKX.get(i6) == null || bKX.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bLf = bKX.get(i6).bLf();
                            bKX.remove(i6);
                            tbRichTextVoiceInfo = bLf;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.tL(sb.length());
                    tbRichTextData.q(spannableString);
                    bKX.add(0, tbRichTextData);
                }
            }
            this.nsm = true;
        }
    }

    private com.baidu.tbadk.core.view.b i(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10);
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0302, dimens4, dimens5);
                bVar.qN(dimens2);
                bVar.jX(false);
                bVar.Cs(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.qN(dimens2);
                bVar2.jX(true);
                bVar2.Cs(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dPi() {
        return this.nrF;
    }

    public void gU(Context context) {
        int type;
        int i;
        if (this.nrD != null) {
            int i2 = -1;
            int size = this.nrE.size();
            if (size > 0) {
                try {
                    i2 = this.nrE.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nrD.size()) {
                l lVar = this.nrD.get(i3);
                if (l.dv(i4, lVar.getType())) {
                    this.nrE.get(size - 1).b(lVar.gT(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nrE.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gT(context));
                        this.nrE.add(lVar2);
                        type = 0;
                    }
                    i = size + 1;
                }
                i3++;
                size = i;
                i4 = type;
            }
        }
    }

    public void gV(Context context) {
        try {
            if (this.nrJ != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nrJ.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nrE == null || this.nrE.size() == 0) {
                gU(context);
            }
            ArrayList<l> arrayList = this.nrE;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dOL() != null) {
                            sb.append((CharSequence) next.dOL());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String DI = TbFaceManager.bGp().DI(next.getText());
                        if (DI != null) {
                            sb.append("[");
                            sb.append(DI);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dOK())) {
                        sb.append("[").append(next.dOK()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (Exception e) {
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nrP = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTY = metaData;
                }
                if (this.eTY.getUserId() == null || this.eTY.getUserId().length() <= 0 || this.eTY.getUserId().equals("0")) {
                    this.eTY = metaData2;
                }
                this.nrJ = TbRichTextView.a(context, subPostList.content, z);
                if (this.nrJ != null) {
                    this.nrJ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.nrC = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTY = metaData;
                }
                this.jog = post.need_log.intValue() == 1;
                this.nsa = post.img_num_abtest.intValue() == 1;
                this.nrS = new bv();
                this.nrS.parserProtobuf(post.from_forum);
                if (this.eTY.getUserId() == null || this.eTY.getUserId().length() <= 0 || this.eTY.getUserId().equals("0")) {
                    this.eTY.parserProtobuf(post.author);
                }
                if (this.eTY != null && context != null) {
                    this.nrW = this.eTY.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nrX = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eTY.getLevel_id()));
                }
                this.nrM = post.is_ntitle.intValue() == 1;
                this.nrF = post.sub_post_number.intValue();
                this.nrR = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nss = post.content;
                this.nsq = post.is_wonderful_post.intValue() == 1;
                this.nsn = post.is_top_agree_post.intValue() == 1;
                this.eQZ = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eWt = post.item;
                }
                this.nrJ = TbRichTextView.a(context, list, true);
                if (this.nrJ != null) {
                    this.nrJ.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nrJ.tK(this.floor_num);
                    if (this.eTY != null) {
                        this.nrJ.setAuthorId(this.eTY.getUserId());
                    }
                    int count = x.getCount(this.eQZ);
                    if (this.floor_num == 1 && count != 0 && this.eQZ != null) {
                        ArrayList<TbRichTextData> bKX = this.nrJ.bKX();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bKX, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                x.add(bKX, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) x.getItem(this.eQZ, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.r(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eQZ.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eQZ.get(size);
                                if (headItem2 != null) {
                                    a(bKX, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eWt != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eWt));
                        x.add(this.nrJ.bKX(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nrP = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.yd(this.nsl);
                            postData.a(subPostList, context);
                            this.nrG.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nrL.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nrN = new com.baidu.tbadk.data.c();
                    this.nrN.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nrO = new com.baidu.tbadk.data.g();
                    this.nrO.a(post.lbs_info);
                }
                this.eUG = post.storecount.intValue();
                this.nrK.a(post.present);
                this.eUj.setUserMap(this.userMap);
                this.eUj.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.mdt = new SmallTailInfo();
                    this.mdt.id = post.signature.signature_id.intValue();
                    this.mdt.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.mdt.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.mdt.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.mdt.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eUS.add(cVar);
                    }
                }
                this.eUV = post.skin_info;
                this.eUY = post.lego_card;
                this.nrY = post.tpoint_post;
                if (post.agree != null) {
                    this.nrZ = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nrZ = false;
                }
                this.nsg = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eVB = new OriginalThreadInfo();
                    this.eVB.a(post.origin_thread_info);
                } else {
                    this.eVB = null;
                }
                this.nsj = post.is_fold.intValue();
                this.lGu = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.q(spannableStringBuilder);
        x.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nsA;
        private b nsB;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nsA = new SoftReference<>(context);
            this.nsB = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nsA != null && this.nsA.get() != null) {
                if (this.nsB != null) {
                    this.nsB.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nsA.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gW(Context context) {
        ArrayList<TbRichTextData> bKX;
        if (this.nrJ == null || (bKX = this.nrJ.bKX()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bKX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bLe().toString());
            } else if (next.getType() == 17) {
                String str = next.bLi().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dPj() {
        ArrayList<TbRichTextData> bKX;
        String str;
        if (this.nrJ == null || (bKX = this.nrJ.bKX()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bKX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bLe().toString());
                } else if (next.getType() == 17) {
                    if (next.bLi() != null && next.bLi().mGifInfo != null && (str = next.bLi().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dPk() {
        ArrayList<TbRichTextData> bKX;
        if (this.nrJ != null && (bKX = this.nrJ.bKX()) != null) {
            Iterator<TbRichTextData> it = bKX.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bLd().getWidth();
                    preLoadImageInfo.height = next.bLd().getHeight();
                    preLoadImageInfo.imgUrl = next.bLd().bLq();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bLj().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bLj().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bLj().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dPl() {
        k dOI;
        PreLoadImageInfo dPk = dPk();
        if (dPk != null && !StringUtils.isNull(dPk.imgUrl)) {
            return dPk.imgUrl;
        }
        if (this.nrR != null && (dOI = this.nrR.dOI()) != null && !StringUtils.isNull(dOI.dOJ())) {
            return dOI.dOJ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bKX;
        if (this.nrJ == null || (bKX = this.nrJ.bKX()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bKX.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bLd().getWidth();
                preLoadImageInfo.height = next.bLd().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bLd().bLv()) {
                    preLoadImageInfo.imgUrl = next.bLd().bLr();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bLd().bLq();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bLi() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bLi().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bLi().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bLi();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.eTY == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eTY.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nrB == 52) {
            return nrx;
        }
        if (this.nrB == 1) {
            return eUW;
        }
        if (this.nrB == 36) {
            return eTd;
        }
        if (this.nrB == 40 || this.nrB == 50) {
            return eTj;
        }
        if (this.nrB == 41) {
            return nrv;
        }
        if (this.nrB == 53) {
            return nry;
        }
        if (dPe() == 1) {
            return nrt;
        }
        return nru;
    }

    public void setPostType(int i) {
        this.nrB = i;
    }

    public az dPm() {
        return this.nrK;
    }

    public void a(az azVar) {
        this.nrK = azVar;
    }

    public i dPn() {
        return this.nrR;
    }

    public com.baidu.tbadk.widget.richText.i bLh() {
        if (this.nrV != null) {
            return this.nrV;
        }
        if (this.nrJ != null && x.getCount(this.nrJ.bKX()) > 0) {
            Iterator<TbRichTextData> it = this.nrJ.bKX().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nrV = next.bLh();
                    return this.nrV;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bLf() {
        if (this.fnv != null) {
            return this.fnv;
        }
        if (this.nrJ != null && x.getCount(this.nrJ.bKX()) > 0) {
            Iterator<TbRichTextData> it = this.nrJ.bKX().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fnv = next.bLf();
                    return this.fnv;
                }
            }
        }
        return null;
    }

    public String dPo() {
        return this.nrW;
    }

    public String bsD() {
        return this.eUY;
    }

    public void bsF() {
        if (this.eUv == 0) {
            this.eUv = 1;
        }
    }

    public long bsT() {
        return this.agreeData.disAgreeNum;
    }

    public int bsV() {
        return this.agreeData.agreeType;
    }

    public AgreeData btl() {
        return this.agreeData;
    }

    public OriginalThreadInfo dPp() {
        return this.eVB;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eVB = originalThreadInfo;
    }

    public int dPq() {
        return this.nsj;
    }

    public String dmQ() {
        return this.lGu;
    }

    public Item bty() {
        return this.eWt;
    }

    public List<HeadItem> btz() {
        return this.eQZ;
    }
}
