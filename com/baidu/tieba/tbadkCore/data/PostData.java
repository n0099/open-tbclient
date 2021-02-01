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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
public class PostData implements com.baidu.adp.widget.ListView.n, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private List<HeadItem> eOA;
    private SkinInfo eSw;
    private String eSz;
    private Item eTW;
    private OriginalThreadInfo eTc;
    private TbRichTextVoiceInfo fld;
    public int isAuthorView;
    private String lKC;
    public int locate;
    private SmallTailInfo mhR;
    private String nwG;
    private ArrayList<PostData> nwK;
    private com.baidu.tbadk.data.c nwR;
    private com.baidu.tbadk.data.g nwS;
    private i nwV;
    private bx nwW;
    public boolean nwY;
    private com.baidu.tbadk.widget.richText.i nwZ;
    private String nxa;
    private String nxb;
    private TPointPost nxc;
    public int nxf;
    public boolean nxi;
    public AlaLiveInfoCoreData nxl;
    private boolean nxp;
    public ar nxt;
    public List<PbContent> nxw;
    public Item nxy;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId nwx = BdUniqueId.gen();
    public static final BdUniqueId nwy = BdUniqueId.gen();
    public static final BdUniqueId eSx = BdUniqueId.gen();
    public static final BdUniqueId eQE = BdUniqueId.gen();
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public static final BdUniqueId nwz = BdUniqueId.gen();
    public static final BdUniqueId nwA = BdUniqueId.gen();
    public static final BdUniqueId nwB = BdUniqueId.gen();
    public static final BdUniqueId nwC = BdUniqueId.gen();
    public static final BdUniqueId nwD = BdUniqueId.gen();
    public static boolean nwE = false;
    private int nwF = 0;
    private boolean nwL = false;
    private ArrayList<PostData> nwM = null;
    private TbRichText nwN = null;
    private boolean nwQ = false;
    private boolean nwT = false;
    private boolean nwU = false;
    public boolean nwX = false;
    public int eRW = 0;
    private boolean nxd = false;
    public boolean jpg = false;
    public boolean nxe = false;
    public boolean nxg = false;
    public boolean nxh = true;
    public boolean nxj = false;
    public boolean nxk = false;
    private boolean nxm = false;
    private int nxn = 0;
    private boolean nxo = true;
    public boolean nxq = false;
    public boolean nxr = false;
    public boolean nxs = false;
    public boolean nxu = false;
    public boolean nxv = false;
    int nxx = com.baidu.tbadk.a.d.bji();
    private b nxz = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.nxt != null) {
                ar bsN = PostData.this.nxt.bsN();
                bsN.delete("obj_locate");
                bsN.ap("obj_locate", 7);
                TiebaStatic.log(bsN);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData eRz = new MetaData();
    private ArrayList<l> nwH = new ArrayList<>();
    private ArrayList<l> nwI = new ArrayList<>();
    private int nwJ = 0;
    private int eSh = 0;
    private PraiseData eRK = new PraiseData();
    private bb nwO = new bb();
    private c nwP = new c();
    private ArrayList<com.baidu.tbadk.data.c> eSt = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.nwK = null;
        this.nxf = 0;
        this.nwK = new ArrayList<>();
        this.nxf = 0;
    }

    public void ys(boolean z) {
        this.nxp = z;
    }

    public boolean dNp() {
        return this.nxp;
    }

    public ArrayList<PostData> dNq() {
        return this.nwM;
    }

    public void dNr() {
        this.nwM.clear();
        this.nwM = null;
        this.nwL = false;
    }

    public void y(PostData postData) {
        if (postData != null) {
            if (this.nwM == null) {
                this.nwM = new ArrayList<>();
                if (y.getCount(this.nwK) > this.nxx) {
                    this.nwM.addAll(y.subList(this.nwK, 0, this.nxx));
                } else {
                    this.nwM.addAll(this.nwK);
                }
            }
            this.nwM.add(postData);
        }
    }

    public void z(PostData postData) {
        if (postData != null && this.nwK != null) {
            this.nwK.add(postData);
            dNv();
        }
    }

    public void Te(String str) {
        if (this.nwM != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.nwM.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.nwM.remove(next);
                    return;
                }
            }
        }
    }

    public void yt(boolean z) {
        this.nxo = z;
    }

    public boolean dNs() {
        return this.nxo;
    }

    public void yu(boolean z) {
        this.nwL = z;
    }

    public boolean dNt() {
        return this.nwL;
    }

    public ArrayList<PostData> dNu() {
        return this.nwK;
    }

    public void dNv() {
        this.nwJ++;
    }

    public void dNw() {
        this.nwJ--;
    }

    public void JD(int i) {
        this.nwJ = i;
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

    public int dNx() {
        return this.floor_num;
    }

    public void JE(int i) {
        this.floor_num = i;
    }

    public boolean dNy() {
        return this.nwU;
    }

    public void yv(boolean z) {
        this.nwU = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = au.getFormatTime(j);
    }

    public MetaData bnQ() {
        return this.eRz;
    }

    public void a(MetaData metaData) {
        this.eRz = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eRK = praiseData;
    }

    public TbRichText dNz() {
        return this.nwN;
    }

    public void c(TbRichText tbRichText) {
        this.nwN = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dtl() {
        return this.mhR;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.mhR = smallTailInfo;
    }

    public com.baidu.tbadk.data.g dNA() {
        return this.nwS;
    }

    public SkinInfo bol() {
        return this.eSw;
    }

    public void yw(boolean z) {
        this.nxm = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.nwN != null && this.nwN.bHz() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            String str3 = null;
            if (z) {
                str = " 楼主";
            } else {
                if (this.eRz != null && this.eRz.getIs_bawu() == 1) {
                    if (this.nxp) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.eRz.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.eRz.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.eRz.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.eRz.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bnQ().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mw().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.d.mw().a(next.getIcon(), 21, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.c
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.nwN.isChanged = true;
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
            if (!StringUtils.isNull(this.eRz.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.eRz.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.eRz != null) {
                spannableString = new SpannableString(sb2 + this.eRz.getName_show() + str + "：");
                String userName = this.eRz.getUserName();
                str2 = this.eRz.getUserId();
                str3 = userName;
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.eRz.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.eRz.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str3, str2, this.nxz), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.eRz != null && this.eRz.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b i3 = i(z, this.eRz != null && this.eRz.getIs_bawu() == 1, str);
                if (i3 != null) {
                    if (this.eRz != null) {
                        int i4 = 0;
                        if (this.eRz.getName_show() != null) {
                            i4 = this.eRz.getName_show().length();
                        }
                        spannableString.setSpan(i3, sb2.length() + i4 + 1, i4 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(i3, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bHz = this.nwN.bHz();
            if (bHz != null && bHz.size() > 0) {
                TbRichTextData tbRichTextData2 = bHz.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bHG() != null) {
                    if (this.nxm) {
                        int indexOf = tbRichTextData2.bHG().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bHG().delete(0, indexOf + 1);
                        }
                        this.nxm = false;
                    }
                    tbRichTextData2.sk(sb.length());
                    tbRichTextData2.bHG().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= bHz.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bHz.get(i6) == null || bHz.get(i6).getType() != 512) {
                            i5 = i6 + 1;
                        } else {
                            TbRichTextVoiceInfo bHH = bHz.get(i6).bHH();
                            bHz.remove(i6);
                            tbRichTextVoiceInfo = bHH;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.sk(sb.length());
                    tbRichTextData.p(spannableString);
                    bHz.add(0, tbRichTextData);
                }
            }
            this.nxq = true;
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
                bVar.pl(dimens2);
                bVar.jW(false);
                bVar.By(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                com.baidu.tbadk.core.view.b bVar2 = new com.baidu.tbadk.core.view.b(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens5);
                bVar2.pl(dimens2);
                bVar2.jW(true);
                bVar2.By(str);
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

    public int dNB() {
        return this.nwJ;
    }

    public void gV(Context context) {
        int type;
        int i;
        if (this.nwH != null) {
            int i2 = -1;
            int size = this.nwI.size();
            if (size > 0) {
                try {
                    i2 = this.nwI.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.nwH.size()) {
                l lVar = this.nwH.get(i3);
                if (l.ds(i4, lVar.getType())) {
                    this.nwI.get(size - 1).b(lVar.gU(context));
                    i = size;
                    type = i4;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.nwI.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.gU(context));
                        this.nwI.add(lVar2);
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

    public void gW(Context context) {
        try {
            if (this.nwN != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.nwN.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.nwI == null || this.nwI.size() == 0) {
                gV(context);
            }
            ArrayList<l> arrayList = this.nwI;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dNe() != null) {
                            sb.append((CharSequence) next.dNe());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String CO = TbFaceManager.bCO().CO(next.getText());
                        if (CO != null) {
                            sb.append("[");
                            sb.append(CO);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !au.isEmpty(next.dNd())) {
                        sb.append("[").append(next.dNd()).append("]");
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
                this.date = au.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.nwT = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eRz = metaData;
                }
                if (this.eRz.getUserId() == null || this.eRz.getUserId().length() <= 0 || this.eRz.getUserId().equals("0")) {
                    this.eRz = metaData2;
                }
                this.nwN = TbRichTextView.a(context, subPostList.content, z);
                if (this.nwN != null) {
                    this.nwN.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
                this.isAuthorView = subPostList.is_author_view.intValue();
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
                this.date = au.getFormatTime(this.time);
                this.nwG = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eRz = metaData;
                }
                this.jpg = post.need_log.intValue() == 1;
                this.nxe = post.img_num_abtest.intValue() == 1;
                this.nwW = new bx();
                this.nwW.parserProtobuf(post.from_forum);
                if (this.eRz.getUserId() == null || this.eRz.getUserId().length() <= 0 || this.eRz.getUserId().equals("0")) {
                    this.eRz.parserProtobuf(post.author);
                }
                if (this.eRz != null && context != null) {
                    this.nxa = this.eRz.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.nxb = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.eRz.getLevel_id()));
                }
                this.nwQ = post.is_ntitle.intValue() == 1;
                this.nwJ = post.sub_post_number.intValue();
                this.nwV = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.nxw = post.content;
                this.nxu = post.is_wonderful_post.intValue() == 1;
                this.nxr = post.is_top_agree_post.intValue() == 1;
                this.eOA = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.eTW = post.item;
                }
                if (this.eTW == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0 && com.baidu.tbadk.a.d.bjz()) {
                    this.nxy = post.outer_item;
                }
                this.nwN = TbRichTextView.a(context, list, String.valueOf(post.tid), true);
                if (this.nwN != null) {
                    this.nwN.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.nwN.sj(this.floor_num);
                    if (this.eRz != null) {
                        this.nwN.setAuthorId(this.eRz.getUserId());
                    }
                    int count = y.getCount(this.eOA);
                    if (this.floor_num == 1 && count != 0 && this.eOA != null) {
                        ArrayList<TbRichTextData> bHz = this.nwN.bHz();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bHz, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bHz, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.eOA, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.q(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.eOA.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.eOA.get(size);
                                if (headItem2 != null) {
                                    a(bHz, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.eTW != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.eTW));
                        y.add(this.nwN.bHz(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.nwT = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.ys(this.nxp);
                            postData.a(subPostList, context);
                            this.nwK.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.nwP.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.nwR = new com.baidu.tbadk.data.c();
                    this.nwR.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.nwS = new com.baidu.tbadk.data.g();
                    this.nwS.a(post.lbs_info);
                }
                this.eSh = post.storecount.intValue();
                this.nwO.a(post.present);
                this.eRK.setUserMap(this.userMap);
                this.eRK.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.mhR = new SmallTailInfo();
                    this.mhR.id = post.signature.signature_id.intValue();
                    this.mhR.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.mhR.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.mhR.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.mhR.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.eSt.add(cVar);
                    }
                }
                this.eSw = post.skin_info;
                this.eSz = post.lego_card;
                this.nxc = post.tpoint_post;
                if (post.agree != null) {
                    this.nxd = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.nxd = false;
                }
                this.nxk = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.eTc = new OriginalThreadInfo();
                    this.eTc.a(post.origin_thread_info);
                } else {
                    this.eTc = null;
                }
                this.nxn = post.is_fold.intValue();
                this.lKC = post.fold_tip;
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
        tbRichTextData.p(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private String mId;
        private String mName;
        private SoftReference<Context> nxF;
        private b nxG;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.nxF = new SoftReference<>(context);
            this.nxG = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0108));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(true);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.nxF != null && this.nxF.get() != null) {
                if (this.nxG != null) {
                    this.nxG.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.nxF.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String gX(Context context) {
        ArrayList<TbRichTextData> bHz;
        if (this.nwN == null || (bHz = this.nwN.bHz()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bHG().toString());
            } else if (next.getType() == 17) {
                String str = next.bHK().mGifInfo.mSharpText;
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

    public String dNC() {
        ArrayList<TbRichTextData> bHz;
        String str;
        if (this.nwN == null || (bHz = this.nwN.bHz()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bHG().toString());
                } else if (next.getType() == 17) {
                    if (next.bHK() != null && next.bHK().mGifInfo != null && (str = next.bHK().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dND() {
        ArrayList<TbRichTextData> bHz;
        if (this.nwN != null && (bHz = this.nwN.bHz()) != null) {
            Iterator<TbRichTextData> it = bHz.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bHF().getWidth();
                    preLoadImageInfo.height = next.bHF().getHeight();
                    preLoadImageInfo.imgUrl = next.bHF().bHS();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bHL().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bHL().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bHL().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dNE() {
        k dNb;
        PreLoadImageInfo dND = dND();
        if (dND != null && !StringUtils.isNull(dND.imgUrl)) {
            return dND.imgUrl;
        }
        if (this.nwV != null && (dNb = this.nwV.dNb()) != null && !StringUtils.isNull(dNb.dNc())) {
            return dNb.dNc();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bHz;
        if (this.nwN == null || (bHz = this.nwN.bHz()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bHz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bHF().getWidth();
                preLoadImageInfo.height = next.bHF().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHF().bHX()) {
                    preLoadImageInfo.imgUrl = next.bHF().bHT();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bHF().bHS();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bHK() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bHK().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bHK().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bHK();
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
        if (this.eRz == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.eRz.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.nwF == 52) {
            return nwB;
        }
        if (this.nwF == 1) {
            return eSx;
        }
        if (this.nwF == 36) {
            return eQE;
        }
        if (this.nwF == 40 || this.nwF == 50) {
            return eQK;
        }
        if (this.nwF == 41) {
            return nwz;
        }
        if (this.nwF == 53) {
            return nwC;
        }
        if (dNx() == 1) {
            return nwx;
        }
        return nwy;
    }

    public void setPostType(int i) {
        this.nwF = i;
    }

    public bb dNF() {
        return this.nwO;
    }

    public void a(bb bbVar) {
        this.nwO = bbVar;
    }

    public i dNG() {
        return this.nwV;
    }

    public com.baidu.tbadk.widget.richText.i bHJ() {
        if (this.nwZ != null) {
            return this.nwZ;
        }
        if (this.nwN != null && y.getCount(this.nwN.bHz()) > 0) {
            Iterator<TbRichTextData> it = this.nwN.bHz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.nwZ = next.bHJ();
                    return this.nwZ;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bHH() {
        if (this.fld != null) {
            return this.fld;
        }
        if (this.nwN != null && y.getCount(this.nwN.bHz()) > 0) {
            Iterator<TbRichTextData> it = this.nwN.bHz().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.fld = next.bHH();
                    return this.fld;
                }
            }
        }
        return null;
    }

    public String dNH() {
        return this.nxa;
    }

    public String bpb() {
        return this.eSz;
    }

    public void bpd() {
        if (this.eRW == 0) {
            this.eRW = 1;
        }
    }

    public long bpr() {
        return this.agreeData.disAgreeNum;
    }

    public int bpt() {
        return this.agreeData.agreeType;
    }

    public AgreeData bpJ() {
        return this.agreeData;
    }

    public OriginalThreadInfo dNI() {
        return this.eTc;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.eTc = originalThreadInfo;
    }

    public int dNJ() {
        return this.nxn;
    }

    public String dlk() {
        return this.lKC;
    }

    public Item bpW() {
        return this.eTW;
    }

    public List<HeadItem> bpX() {
        return this.eOA;
    }
}
