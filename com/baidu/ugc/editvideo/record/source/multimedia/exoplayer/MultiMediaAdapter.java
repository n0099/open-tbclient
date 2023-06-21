package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.text.TextUtils;
import com.baidu.tieba.wwa;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class MultiMediaAdapter {
    public static String TAG = "com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter";
    public int mCurItem = -1;
    public List<ItemInfo> mItems = new ArrayList();
    public List<ItemInfo> mChangedList = new ArrayList();
    public boolean isLoopingPreload = true;

    /* loaded from: classes8.dex */
    public static final class ItemInfo {
        public MultiMediaData data;
        public int position;

        public ItemInfo() {
        }
    }

    private ItemInfo getNext() {
        int count = getCount();
        int i = this.mCurItem + 1;
        if (this.isLoopingPreload && i == count && count > 2) {
            i = 0;
        }
        while (i < count) {
            if (isPlayerType(i)) {
                ItemInfo infoForPosition = infoForPosition(i);
                if (infoForPosition == null) {
                    MultiMediaData instantiatePlayer = instantiatePlayer(i);
                    if (instantiatePlayer == null) {
                        return null;
                    }
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.data = instantiatePlayer;
                    itemInfo.position = i;
                    return itemInfo;
                }
                return infoForPosition;
            }
            i++;
        }
        return null;
    }

    private ItemInfo getPrevious() {
        int i = this.mCurItem;
        while (true) {
            i--;
            if (i < 0) {
                return null;
            }
            if (isPlayerType(i)) {
                ItemInfo infoForPosition = infoForPosition(i);
                if (infoForPosition == null) {
                    MultiMediaData instantiatePlayer = instantiatePlayer(i);
                    if (instantiatePlayer == null) {
                        return null;
                    }
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.data = instantiatePlayer;
                    itemInfo.position = i;
                    return itemInfo;
                }
                return infoForPosition;
            }
        }
    }

    public synchronized void clear() {
        int b = wwa.b(this.mItems);
        for (int i = 0; i < b; i++) {
            ItemInfo itemInfo = (ItemInfo) wwa.c(this.mItems, i);
            if (itemInfo != null) {
                destroyPlayer(itemInfo.position, itemInfo.data);
            }
        }
        this.mItems.clear();
    }

    public synchronized void clearByIndex(int i) {
        int b = wwa.b(this.mItems);
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 < b) {
                ItemInfo itemInfo = (ItemInfo) wwa.c(this.mItems, i3);
                if (itemInfo != null && itemInfo.position == i) {
                    destroyPlayer(itemInfo.position, itemInfo.data);
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        wwa.g(this.mItems, i2);
    }

    public abstract void destroyPlayer(int i, MultiMediaData multiMediaData);

    public abstract int getCount();

    public ItemInfo infoForPosition(int i) {
        int b = wwa.b(this.mItems);
        for (int i2 = 0; i2 < b; i2++) {
            ItemInfo itemInfo = (ItemInfo) wwa.c(this.mItems, i2);
            if (itemInfo != null && itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    public abstract MultiMediaData instantiatePlayer(int i);

    public abstract boolean isPlayerType(int i);

    public synchronized void positionChanged(int i) {
        int i2;
        int i3;
        this.mChangedList.clear();
        this.mCurItem = i;
        boolean isPlayerType = isPlayerType(i);
        if (isPlayerType) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition == null) {
                MultiMediaData instantiatePlayer = instantiatePlayer(this.mCurItem);
                if (instantiatePlayer != null) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfo.data = instantiatePlayer;
                    itemInfo.position = this.mCurItem;
                    this.mChangedList.add(itemInfo);
                }
            } else {
                this.mChangedList.add(infoForPosition);
            }
        }
        ItemInfo previous = getPrevious();
        if (previous != null) {
            i2 = previous.position;
            this.mChangedList.add(previous);
        } else {
            i2 = -1;
        }
        ItemInfo next = getNext();
        if (next != null) {
            i3 = next.position;
            this.mChangedList.add(next);
        } else {
            i3 = -1;
        }
        int b = wwa.b(this.mItems);
        for (int i4 = 0; i4 < b; i4++) {
            ItemInfo itemInfo2 = (ItemInfo) wwa.c(this.mItems, i4);
            if (itemInfo2 != null && itemInfo2.position != i2 && itemInfo2.position != i3 && itemInfo2.position != this.mCurItem) {
                destroyPlayer(itemInfo2.position, itemInfo2.data);
            }
        }
        this.mItems.clear();
        wwa.a(this.mItems, this.mChangedList);
        this.mChangedList.clear();
        if (!isPlayerType) {
            this.mCurItem = -1;
        }
    }

    public synchronized void seek0AndClearOther(MultiMediaData multiMediaData, int i) {
        int b = wwa.b(this.mItems);
        for (int i2 = 0; i2 < b; i2++) {
            ItemInfo itemInfo = (ItemInfo) wwa.c(this.mItems, i2);
            if (itemInfo != null) {
                if (multiMediaData == null || itemInfo.data == null || !TextUtils.equals(multiMediaData.uuid, itemInfo.data.uuid)) {
                    destroyPlayer(itemInfo.position, itemInfo.data);
                    wwa.g(this.mItems, i2);
                } else {
                    itemInfo.position = i;
                }
            }
        }
    }
}
